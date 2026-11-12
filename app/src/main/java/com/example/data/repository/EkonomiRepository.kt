package com.example.data.repository

import com.example.data.local.AppDatabase
import com.example.data.local.AppPreferences
import com.example.data.model.Bookmark
import com.example.data.model.HasilLatihan
import com.example.data.model.LkpdSubmission
import com.example.data.model.User
import kotlinx.coroutines.flow.Flow
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class EkonomiRepository(
    private val database: AppDatabase,
    val preferences: AppPreferences
) {
    val userDao = database.userDao()
    val hasilLatihanDao = database.hasilLatihanDao()
    val bookmarkDao = database.bookmarkDao()
    val lkpdSubmissionDao = database.lkpdSubmissionDao()

    fun getUser(): Flow<User?> = userDao.getUser()

    suspend fun getOrCreateUser(): User {
        val existing = userDao.getUserSync()
        if (existing != null) return existing

        val dateStr = SimpleDateFormat("dd MMM yyyy", Locale("id", "ID")).format(Date())
        val newUser = User(
            id = 1,
            nama = "Siswa SMANSA",
            kelas = "X Cermat",
            avatarId = 1,
            xp = 0,
            level = 1,
            lencanaTerbuka = "LANGKAH_AWAL",
            tanggalDaftar = dateStr
        )
        userDao.insertOrUpdate(newUser)
        return newUser
    }

    suspend fun updateUserProfile(nama: String, kelas: String, avatarId: Int) {
        val user = getOrCreateUser()
        userDao.insertOrUpdate(user.copy(nama = nama, kelas = kelas, avatarId = avatarId))
    }

    data class XpRewardResult(
        val gainedXp: Int,
        val newXp: Int,
        val newLevel: Int,
        val leveledUp: Boolean,
        val newBadges: List<String>
    )

    suspend fun addXp(amount: Int): XpRewardResult {
        val user = getOrCreateUser()
        val oldXp = user.xp
        val newXp = oldXp + amount
        val oldLevel = user.level
        val newLevel = calculateLevel(newXp)
        val leveledUp = newLevel > oldLevel

        // Check badges
        val currentBadges = user.lencanaTerbuka.split(",").filter { it.isNotBlank() }.toMutableSet()
        val newBadgesList = mutableListOf<String>()

        if (!currentBadges.contains("LANGKAH_AWAL")) {
            currentBadges.add("LANGKAH_AWAL")
            newBadgesList.add("LANGKAH_AWAL")
        }

        if (preferences.getReadSubbabsCount() >= 5 && !currentBadges.contains("KUTU_BUKU")) {
            currentBadges.add("KUTU_BUKU")
            newBadgesList.add("KUTU_BUKU")
        }

        if (newLevel >= 5 && !currentBadges.contains("MASTER_SMANSA")) {
            currentBadges.add("MASTER_SMANSA")
            newBadgesList.add("MASTER_SMANSA")
        }

        userDao.updateXpAndLevel(newXp, newLevel, currentBadges.joinToString(","))

        return XpRewardResult(
            gainedXp = amount,
            newXp = newXp,
            newLevel = newLevel,
            leveledUp = leveledUp,
            newBadges = newBadgesList
        )
    }

    suspend fun unlockBadge(badgeId: String): Boolean {
        val user = getOrCreateUser()
        val currentBadges = user.lencanaTerbuka.split(",").filter { it.isNotBlank() }.toMutableSet()
        if (currentBadges.add(badgeId)) {
            userDao.updateXpAndLevel(user.xp, user.level, currentBadges.joinToString(","))
            return true
        }
        return false
    }

    fun calculateLevel(xp: Int): Int {
        return when {
            xp <= 100 -> 1
            xp <= 300 -> 2
            xp <= 600 -> 3
            xp <= 1000 -> 4
            else -> 5
        }
    }

    fun getLevelTitle(level: Int): String {
        return when (level) {
            1 -> "Calon Ekonom Pemula"
            2 -> "Pembelajar Aktif"
            3 -> "Pengamat Pasar Cermat"
            4 -> "Analis Ekonomi Muda"
            else -> "Master Ekonomi SMANSA"
        }
    }

    // Bookmarks
    fun getAllBookmarks(): Flow<List<Bookmark>> = bookmarkDao.getAllBookmarks()
    fun isBookmarked(subbabId: String): Flow<Boolean> = bookmarkDao.isBookmarked(subbabId)

    suspend fun toggleBookmark(babId: Int, subbabId: String, judulBab: String, judulSubbab: String): Boolean {
        val isMarked = bookmarkDao.isBookmarkedSync(subbabId)
        if (isMarked) {
            bookmarkDao.deleteBySubbabId(subbabId)
            return false
        } else {
            val dateStr = SimpleDateFormat("dd/MM/yyyy", Locale("id", "ID")).format(Date())
            bookmarkDao.insert(
                Bookmark(
                    babId = babId,
                    subbabId = subbabId,
                    judulBab = judulBab,
                    judulSubbab = judulSubbab,
                    tanggal = dateStr
                )
            )
            return true
        }
    }

    // Hasil Latihan
    fun getAllHasil(): Flow<List<HasilLatihan>> = hasilLatihanDao.getAllHasil()
    fun getHasilByBab(bab: Int): Flow<List<HasilLatihan>> = hasilLatihanDao.getHasilByBab(bab)

    suspend fun saveHasilLatihan(
        bab: Int,
        judulBab: String,
        skor: Int,
        totalSoal: Int,
        waktuDetik: Int
    ): HasilLatihan {
        val persentase = if (totalSoal > 0) (skor * 100) / totalSoal else 0
        val predikat = when {
            persentase >= 85 -> "Sangat Baik"
            persentase >= 70 -> "Baik"
            persentase >= 55 -> "Cukup"
            else -> "Perlu Belajar Lagi"
        }
        val dateStr = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale("id", "ID")).format(Date())

        val hasil = HasilLatihan(
            userId = 1,
            bab = bab,
            judulBab = judulBab,
            skor = skor,
            totalSoal = totalSoal,
            persentase = persentase,
            predikat = predikat,
            tanggal = dateStr,
            waktuDetik = waktuDetik
        )
        hasilLatihanDao.insert(hasil)

        // Award XP (+10 per correct answer)
        val earnedXp = skor * 10
        addXp(earnedXp)

        // Check badge PENEMBAK_JITU (100% score)
        if (persentase == 100) {
            unlockBadge("PENEMBAK_JITU")
        }

        // Check badge PAKAR_PASAR (Bab 3 >= 80%)
        if (bab == 3 && persentase >= 80) {
            unlockBadge("PAKAR_PASAR")
        }

        // Check badge PELINDUNG_FINANSIAL (Bab 5 or 6 >= 80%)
        if ((bab == 5 || bab == 6) && persentase >= 80) {
            unlockBadge("PELINDUNG_FINANSIAL")
        }

        return hasil
    }

    // LKPD Submissions
    fun getSubmissionByBab(babId: Int): Flow<LkpdSubmission?> = lkpdSubmissionDao.getSubmissionByBab(babId)
    fun getAllSubmissions(): Flow<List<LkpdSubmission>> = lkpdSubmissionDao.getAllSubmissions()

    suspend fun saveLkpdSubmission(
        babId: Int,
        judulLkpd: String,
        namaSiswa: String,
        kelas: String,
        jawaban: String,
        isCompleted: Boolean
    ) {
        val dateStr = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale("id", "ID")).format(Date())
        val submission = LkpdSubmission(
            babId = babId,
            judulLkpd = judulLkpd,
            namaSiswa = namaSiswa,
            kelas = kelas,
            tanggal = dateStr,
            jawaban = jawaban,
            status = if (isCompleted) "Selesai" else "Draf",
            tanggalSimpan = dateStr
        )
        lkpdSubmissionDao.insertOrUpdate(submission)

        if (isCompleted) {
            addXp(50) // +50 XP for completing LKPD
            unlockBadge("CENDEKIA_LKPD")
        }
    }

    // Reset All Data
    suspend fun resetAllData() {
        database.userDao().deleteAll()
        database.hasilLatihanDao().deleteAll()
        database.bookmarkDao().deleteAll()
        database.lkpdSubmissionDao().deleteAll()
        preferences.clearAll()
        getOrCreateUser() // Re-initialize clean user
    }
}
