package com.example.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.AppDatabase
import com.example.data.local.AppPreferences
import com.example.data.model.Bookmark
import com.example.data.model.HasilLatihan
import com.example.data.model.BadgeData
import com.example.data.model.LkpdItem
import com.example.data.model.LkpdSubmission
import com.example.data.model.Soal
import com.example.data.model.User
import com.example.data.repository.EkonomiRepository
import com.example.data.repository.LabData
import com.example.data.repository.LkpdData
import com.example.data.repository.MateriRepository
import com.example.data.repository.SoalData
import com.example.notification.ReminderScheduler
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

sealed interface Screen {
    object Splash : Screen
    object Home : Screen
    data class MateriList(val semester: Int = 1) : Screen
    data class MateriDetail(val subbabId: String) : Screen
    object MateriSearch : Screen
    data class SoalIntro(val babId: Int) : Screen
    data class SoalActive(val babId: Int) : Screen
    data class SoalResult(
        val hasil: HasilLatihan,
        val userAnswers: Map<Int, Int>, // soalId -> selectedOption (0..4 or -1 for skipped)
        val soalList: List<Soal>
    ) : Screen
    data class SoalReview(
        val soalList: List<Soal>,
        val userAnswers: Map<Int, Int>
    ) : Screen
    object LkpdList : Screen
    data class LkpdDetail(val lkpdId: Int) : Screen
    data class LkpdPdfView(val lkpdId: Int) : Screen
    object RekapNilai : Screen
    object Profil : Screen
    object LabMarketSim : Screen
    object LabFraudDetector : Screen
    object Bookmarks : Screen
}

data class CelebrationEvent(
    val title: String,
    val message: String,
    val xpGained: Int = 0,
    val badgeName: String = ""
)

class EkonomiViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getDatabase(application)
    val preferences = AppPreferences(application)
    val repository = EkonomiRepository(db, preferences)

    // User State
    val userState: StateFlow<User?> = repository.getUser()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    // Navigation Stack
    private val screenStack = mutableListOf<Screen>(Screen.Splash)
    private val _currentScreen = MutableStateFlow<Screen>(Screen.Splash)
    val currentScreen: StateFlow<Screen> = _currentScreen.asStateFlow()

    // Settings
    private val _darkMode = MutableStateFlow(preferences.darkMode)
    val darkMode: StateFlow<String> = _darkMode.asStateFlow()

    private val _textScale = MutableStateFlow(preferences.textScale)
    val textScale: StateFlow<Float> = _textScale.asStateFlow()

    private val _reminderEnabled = MutableStateFlow(preferences.reminderEnabled)
    val reminderEnabled: StateFlow<Boolean> = _reminderEnabled.asStateFlow()

    private val _reminderHour = MutableStateFlow(preferences.reminderHour)
    val reminderHour: StateFlow<String> = _reminderHour.asStateFlow()

    // Celebration Dialog Event
    private val _celebrationEvent = MutableStateFlow<CelebrationEvent?>(null)
    val celebrationEvent: StateFlow<CelebrationEvent?> = _celebrationEvent.asStateFlow()

    // Data lists
    val allHasilList = repository.getAllHasil()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val bookmarksList = repository.getAllBookmarks()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val submissionsList = repository.getAllSubmissions()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Quiz Active State
    private var quizTimerJob: Job? = null
    val currentQuizBabId = MutableStateFlow(1)
    val quizSoalList = MutableStateFlow<List<Soal>>(emptyList())
    val quizCurrentIndex = MutableStateFlow(0)
    val quizSelectedOption = MutableStateFlow<Int?>(-1)
    val quizIsAnswered = MutableStateFlow(false)
    val quizTimeLeftSeconds = MutableStateFlow(60)
    val quizIsTimerEnabled = MutableStateFlow(true)
    val quizUserAnswers = MutableStateFlow<MutableMap<Int, Int>>(mutableMapOf())
    val quizScore = MutableStateFlow(0)
    val quizStartTimeMs = MutableStateFlow(0L)

    init {
        viewModelScope.launch {
            repository.getOrCreateUser()
            // Schedule default reminder if enabled
            if (preferences.reminderEnabled) {
                ReminderScheduler.scheduleDailyReminder(getApplication(), preferences.reminderHour)
            }
        }
    }

    // Navigation methods
    fun navigateTo(screen: Screen, clearStack: Boolean = false) {
        if (clearStack) {
            screenStack.clear()
        }
        screenStack.add(screen)
        _currentScreen.value = screen
    }

    fun navigateBack(): Boolean {
        if (screenStack.size > 1) {
            screenStack.removeAt(screenStack.size - 1)
            val prev = screenStack.last()
            _currentScreen.value = prev
            return true
        }
        return false
    }

    fun dismissCelebration() {
        _celebrationEvent.value = null
    }

    // Settings actions
    fun setDarkMode(mode: String) {
        preferences.darkMode = mode
        _darkMode.value = mode
    }

    fun setTextScale(scale: Float) {
        preferences.textScale = scale
        _textScale.value = scale
    }

    fun setReminderEnabled(enabled: Boolean) {
        preferences.reminderEnabled = enabled
        _reminderEnabled.value = enabled
        if (enabled) {
            ReminderScheduler.scheduleDailyReminder(getApplication(), preferences.reminderHour)
        } else {
            ReminderScheduler.cancelReminder(getApplication())
        }
    }

    fun setReminderHour(hour: String) {
        preferences.reminderHour = hour
        _reminderHour.value = hour
        if (preferences.reminderEnabled) {
            ReminderScheduler.scheduleDailyReminder(getApplication(), hour)
        }
    }

    fun updateProfile(nama: String, kelas: String, avatarId: Int) {
        viewModelScope.launch {
            repository.updateUserProfile(nama, kelas, avatarId)
        }
    }

    fun resetData() {
        viewModelScope.launch {
            repository.resetAllData()
            _darkMode.value = preferences.darkMode
            _textScale.value = preferences.textScale
            _reminderEnabled.value = preferences.reminderEnabled
            _reminderHour.value = preferences.reminderHour
            navigateTo(Screen.Home, clearStack = true)
        }
    }

    // Reading & Subbab tracking
    fun onSubbabOpened(subbabId: String) {
        viewModelScope.launch {
            val isFirstRead = preferences.markSubbabRead(subbabId)
            if (isFirstRead) {
                val result = repository.addXp(20)
                if (result.leveledUp) {
                    val title = repository.getLevelTitle(result.newLevel)
                    _celebrationEvent.value = CelebrationEvent(
                        title = "Selamat! Naik Level ${result.newLevel}!",
                        message = "Kamu sekarang menyandang gelar: $title",
                        xpGained = 20
                    )
                } else if (result.newBadges.isNotEmpty()) {
                    val badge = BadgeData.allBadges.find { it.id == result.newBadges.first() }
                    _celebrationEvent.value = CelebrationEvent(
                        title = "Lencana Terbuka!",
                        message = "${badge?.nama ?: "Prestasi Baru"}: ${badge?.deskripsi ?: ""}",
                        xpGained = 20,
                        badgeName = badge?.nama ?: ""
                    )
                }
            }
        }
    }

    fun saveLkpdSubmission(
        babId: Int,
        judulLkpd: String,
        namaSiswa: String,
        kelas: String,
        jawaban: String,
        isCompleted: Boolean
    ) {
        viewModelScope.launch {
            repository.saveLkpdSubmission(
                babId = babId,
                judulLkpd = judulLkpd,
                namaSiswa = namaSiswa,
                kelas = kelas,
                jawaban = jawaban,
                isCompleted = isCompleted
            )
        }
    }

    // Bookmark toggle
    fun toggleBookmark(babId: Int, subbabId: String, judulBab: String, judulSubbab: String) {
        viewModelScope.launch {
            val isExisting = bookmarksList.value.any { it.subbabId == subbabId }
            if (isExisting) {
                repository.bookmarkDao.deleteBySubbabId(subbabId)
            } else {
                val dateStr = java.text.SimpleDateFormat("dd/MM/yyyy", java.util.Locale("id", "ID")).format(java.util.Date())
                repository.bookmarkDao.insert(
                    Bookmark(
                        babId = babId,
                        subbabId = subbabId,
                        judulBab = judulBab,
                        judulSubbab = judulSubbab,
                        tanggal = dateStr
                    )
                )
            }
        }
    }

    // Quiz Management
    fun startQuiz(babId: Int, isTimerEnabled: Boolean) {
        val rawSoal = SoalData.getSoalByBab(babId)
        val shuffled = rawSoal.shuffled() // Randomize order as required by prompt
        quizSoalList.value = shuffled
        currentQuizBabId.value = babId
        quizCurrentIndex.value = 0
        quizScore.value = 0
        quizUserAnswers.value = mutableMapOf()
        quizSelectedOption.value = -1
        quizIsAnswered.value = false
        quizIsTimerEnabled.value = isTimerEnabled
        quizStartTimeMs.value = System.currentTimeMillis()

        navigateTo(Screen.SoalActive(babId))
        startQuestionTimer()
    }

    private fun startQuestionTimer() {
        quizTimerJob?.cancel()
        quizTimeLeftSeconds.value = 60
        quizSelectedOption.value = -1
        quizIsAnswered.value = false

        if (!quizIsTimerEnabled.value) return

        quizTimerJob = viewModelScope.launch {
            while (quizTimeLeftSeconds.value > 0 && !quizIsAnswered.value) {
                delay(1000)
                quizTimeLeftSeconds.value -= 1
            }
            if (!quizIsAnswered.value && quizTimeLeftSeconds.value == 0) {
                // Time up! Auto submit as skipped
                answerQuestion(-1)
            }
        }
    }

    fun answerQuestion(optionIndex: Int) {
        if (quizIsAnswered.value) return
        quizTimerJob?.cancel()
        quizIsAnswered.value = true
        quizSelectedOption.value = optionIndex

        val currentSoal = quizSoalList.value.getOrNull(quizCurrentIndex.value) ?: return
        quizUserAnswers.value[currentSoal.id] = optionIndex

        if (optionIndex == currentSoal.jawabanBenar) {
            quizScore.value += 1
        }
    }

    fun nextQuestion() {
        val nextIdx = quizCurrentIndex.value + 1
        if (nextIdx < quizSoalList.value.size) {
            quizCurrentIndex.value = nextIdx
            startQuestionTimer()
        } else {
            finishQuiz()
        }
    }

    fun skipQuestion() {
        answerQuestion(-1)
    }

    private fun finishQuiz() {
        quizTimerJob?.cancel()
        val durationSec = ((System.currentTimeMillis() - quizStartTimeMs.value) / 1000).toInt()
        val babId = currentQuizBabId.value
        val bab = MateriRepository.getBabById(babId)
        val judulBab = bab?.judul ?: "Bab $babId"

        viewModelScope.launch {
            val hasil = repository.saveHasilLatihan(
                bab = babId,
                judulBab = judulBab,
                skor = quizScore.value,
                totalSoal = quizSoalList.value.size,
                waktuDetik = durationSec
            )

            val earnedXp = quizScore.value * 10
            if (hasil.persentase == 100) {
                _celebrationEvent.value = CelebrationEvent(
                    title = "Skor Sempurna 100%!",
                    message = "Lencana 'Penembak Jitu' terbuka! Kamu berhasil menjawab semua 25 soal dengan benar!",
                    xpGained = earnedXp,
                    badgeName = "Penembak Jitu"
                )
            }

            navigateTo(
                Screen.SoalResult(
                    hasil = hasil,
                    userAnswers = quizUserAnswers.value.toMap(),
                    soalList = quizSoalList.value
                )
            )
        }
    }

    // Market simulation completion
    fun onMarketSimBalanced() {
        viewModelScope.launch {
            val res = repository.addXp(30)
            repository.unlockBadge("PAKAR_PASAR")
            _celebrationEvent.value = CelebrationEvent(
                title = "Ekuilibrium Pasar Tercipta!",
                message = "Kamu berhasil menemukan harga Rp40 dan kuantitas 120 unit! (+30 XP)",
                xpGained = 30,
                badgeName = "Pakar Mekanisme Pasar"
            )
        }
    }

    // Fraud detector completion
    fun onFraudDetectorFinished(score: Int, total: Int) {
        viewModelScope.launch {
            val res = repository.addXp(30)
            if (score >= 4) {
                repository.unlockBadge("PELINDUNG_FINANSIAL")
                _celebrationEvent.value = CelebrationEvent(
                    title = "Detektif Keuangan Handal!",
                    message = "Kamu memahami Prinsip 2L OJK dengan skor $score/$total! (+30 XP)",
                    xpGained = 30,
                    badgeName = "Pelindung Finansial"
                )
            }
        }
    }
}
