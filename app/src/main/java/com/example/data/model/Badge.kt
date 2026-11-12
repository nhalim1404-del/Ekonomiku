package com.example.data.model

data class Badge(
    val id: String,
    val nama: String,
    val deskripsi: String,
    val syarat: String,
    val iconName: String
)

object BadgeData {
    val allBadges = listOf(
        Badge(
            id = "LANGKAH_AWAL",
            nama = "Langkah Awal",
            deskripsi = "Memulai petualangan belajar ekonomi di SMANSA Pangkep.",
            syarat = "Membuka materi pertama atau memulai aplikasi.",
            iconName = "star"
        ),
        Badge(
            id = "KUTU_BUKU",
            nama = "Kutu Buku Ekonomi",
            deskripsi = "Rajin membaca konsep dan teori ekonomi secara mendalam.",
            syarat = "Membaca setidaknya 5 subbab materi.",
            iconName = "menu_book"
        ),
        Badge(
            id = "PENEMBAK_JITU",
            nama = "Penembak Jitu",
            deskripsi = "Akurasi sempurna dalam penguasaan materi latihan soal.",
            syarat = "Meraih skor 100% pada salah satu latihan soal bab.",
            iconName = "emoji_events"
        ),
        Badge(
            id = "PAKAR_PASAR",
            nama = "Pakar Mekanisme Pasar",
            deskripsi = "Menguasai interaksi permintaan, penawaran, dan ekuilibrium harga.",
            syarat = "Meraih skor minimal 80 pada Bab 3 atau menyelesaikan simulasi pasar.",
            iconName = "timeline"
        ),
        Badge(
            id = "PELINDUNG_FINANSIAL",
            nama = "Pelindung Finansial",
            deskripsi = "Cerdas mengenali risiko dan waspada terhadap kejahatan finansial.",
            syarat = "Meraih skor minimal 80 pada Bab 5/6 atau menuntaskan detektor fraud.",
            iconName = "security"
        ),
        Badge(
            id = "CENDEKIA_LKPD",
            nama = "Cendekia LKPD",
            deskripsi = "Mampu menganalisis studi kasus nyata dan menyelesaikan LKPD.",
            syarat = "Menyelesaikan dan menyimpan draf/mengumpulkan 1 LKPD.",
            iconName = "assignment_turned_in"
        ),
        Badge(
            id = "MASTER_SMANSA",
            nama = "Master Ekonomi SMANSA",
            deskripsi = "Gelar kehormatan tertinggi bagi siswa teladan ekonomi SMAN 1 Pangkep.",
            syarat = "Mencapai Level 5 (1001+ XP).",
            iconName = "workspace_premium"
        )
    )
}
