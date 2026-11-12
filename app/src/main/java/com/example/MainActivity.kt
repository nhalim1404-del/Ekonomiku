package com.example

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.components.AppBottomNavBar
import com.example.ui.components.BottomTab
import com.example.ui.components.CelebrationDialog
import com.example.ui.components.SchoolTopHeader
import com.example.ui.games.FraudDetectorScreen
import com.example.ui.games.MarketSimulationScreen
import com.example.ui.home.HomeScreen
import com.example.ui.lkpd.LkpdDetailScreen
import com.example.ui.lkpd.LkpdListScreen
import com.example.ui.lkpd.LkpdPdfViewScreen
import com.example.ui.materi.BookmarksScreen
import com.example.ui.materi.MateriDetailScreen
import com.example.ui.materi.MateriListScreen
import com.example.ui.materi.MateriSearchScreen
import com.example.ui.profil.ProfilScreen
import com.example.ui.rekap.RekapNilaiScreen
import com.example.ui.soal.SoalActiveScreen
import com.example.ui.soal.SoalIntroScreen
import com.example.ui.soal.SoalResultScreen
import com.example.ui.soal.SoalReviewScreen
import com.example.ui.splash.SplashScreen
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.viewmodel.EkonomiViewModel
import com.example.ui.viewmodel.Screen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val viewModel: EkonomiViewModel = viewModel()

            // Observe settings
            val darkModeSetting by viewModel.darkMode.collectAsStateWithLifecycle()
            val textScale by viewModel.textScale.collectAsStateWithLifecycle()

            val isDarkTheme = when (darkModeSetting) {
                "light" -> false
                "dark" -> true
                else -> isSystemInDarkTheme()
            }

            // Notification permission request on Android 13+
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                val permissionLauncher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.RequestPermission()
                ) { isGranted ->
                    // Notification permission handled gracefully
                }

                LaunchedEffect(Unit) {
                    val hasPermission = ContextCompat.checkSelfPermission(
                        this@MainActivity,
                        Manifest.permission.POST_NOTIFICATIONS
                    ) == PackageManager.PERMISSION_GRANTED
                    if (!hasPermission) {
                        permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                    }
                }
            }

            MyApplicationTheme(darkTheme = isDarkTheme) {
                EkonomikuApp(viewModel = viewModel, textScale = textScale)
            }
        }
    }
}

@Composable
fun EkonomikuApp(
    viewModel: EkonomiViewModel,
    textScale: Float
) {
    val currentScreen by viewModel.currentScreen.collectAsStateWithLifecycle()
    val user by viewModel.userState.collectAsStateWithLifecycle()
    val celebrationEvent by viewModel.celebrationEvent.collectAsStateWithLifecycle()

    val hasilList by viewModel.allHasilList.collectAsStateWithLifecycle()
    val bookmarksList by viewModel.bookmarksList.collectAsStateWithLifecycle()
    val submissionsList by viewModel.submissionsList.collectAsStateWithLifecycle()

    // Determine when to show TopBar and BottomBar
    val isTopHeaderVisible = when (currentScreen) {
        is Screen.Splash, is Screen.MateriDetail, is Screen.MateriSearch, is Screen.Bookmarks,
        is Screen.SoalActive, is Screen.SoalResult, is Screen.SoalReview,
        is Screen.LkpdDetail, is Screen.LkpdPdfView, is Screen.LabMarketSim, is Screen.LabFraudDetector -> false
        else -> true
    }

    val isBottomNavVisible = when (currentScreen) {
        is Screen.Home, is Screen.MateriList, is Screen.SoalIntro, is Screen.LkpdList,
        is Screen.RekapNilai, is Screen.Profil -> true
        else -> false
    }

    // Handle back button
    BackHandler(enabled = currentScreen !is Screen.Home && currentScreen !is Screen.Splash) {
        viewModel.navigateBack()
    }

    Scaffold(
        topBar = {
            if (isTopHeaderVisible) {
                SchoolTopHeader(
                    user = user,
                    onSearchClick = { viewModel.navigateTo(Screen.MateriSearch) },
                    onBookmarkClick = { viewModel.navigateTo(Screen.Bookmarks) },
                    onProfileClick = { viewModel.navigateTo(Screen.Profil) }
                )
            }
        },
        bottomBar = {
            if (isBottomNavVisible) {
                AppBottomNavBar(
                    currentScreen = currentScreen,
                    onTabSelected = { tab ->
                        val targetScreen = when (tab) {
                            BottomTab.HOME -> Screen.Home
                            BottomTab.MATERI -> Screen.MateriList(1)
                            BottomTab.SOAL -> Screen.SoalIntro(1)
                            BottomTab.LKPD -> Screen.LkpdList
                            BottomTab.REKAP -> Screen.RekapNilai
                            BottomTab.PROFIL -> Screen.Profil
                        }
                        viewModel.navigateTo(targetScreen)
                    }
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Crossfade(targetState = currentScreen, label = "ScreenTransition") { screen ->
                when (screen) {
                    is Screen.Splash -> {
                        SplashScreen(
                            onSplashFinished = {
                                viewModel.navigateTo(Screen.Home, clearStack = true)
                            }
                        )
                    }

                    is Screen.Home -> {
                        HomeScreen(
                            user = user,
                            hasilList = hasilList,
                            readSubbabsCount = viewModel.preferences.getReadSubbabsCount(),
                            completedLkpdCount = submissionsList.count { it.status == "Selesai" },
                            onNavigateToMateri = { semester ->
                                viewModel.navigateTo(Screen.MateriList(semester))
                            },
                            onNavigateToSoal = { babId ->
                                viewModel.navigateTo(Screen.SoalIntro(babId))
                            },
                            onNavigateToLkpd = {
                                viewModel.navigateTo(Screen.LkpdList)
                            },
                            onNavigateToRekap = {
                                viewModel.navigateTo(Screen.RekapNilai)
                            },
                            onNavigateToProfil = {
                                viewModel.navigateTo(Screen.Profil)
                            },
                            onNavigateToMarketSim = {
                                viewModel.navigateTo(Screen.LabMarketSim)
                            },
                            onNavigateToFraudDetector = {
                                viewModel.navigateTo(Screen.LabFraudDetector)
                            }
                        )
                    }

                    is Screen.MateriList -> {
                        MateriListScreen(
                            initialSemester = screen.semester,
                            bookmarks = bookmarksList,
                            isSubbabRead = { subbabId -> viewModel.preferences.isSubbabRead(subbabId) },
                            onSubbabClick = { subbabId ->
                                viewModel.navigateTo(Screen.MateriDetail(subbabId))
                            },
                            onBookmarkToggle = { babId, subbabId, jBab, jSub ->
                                viewModel.toggleBookmark(babId, subbabId, jBab, jSub)
                            },
                            onSearchClick = {
                                viewModel.navigateTo(Screen.MateriSearch)
                            }
                        )
                    }

                    is Screen.MateriDetail -> {
                        MateriDetailScreen(
                            subbabId = screen.subbabId,
                            textScale = textScale,
                            bookmarks = bookmarksList,
                            onSubbabOpened = { subId -> viewModel.onSubbabOpened(subId) },
                            onBookmarkToggle = { babId, subbabId, jBab, jSub ->
                                viewModel.toggleBookmark(babId, subbabId, jBab, jSub)
                            },
                            onNavigateToSubbab = { nextSubId ->
                                viewModel.navigateTo(Screen.MateriDetail(nextSubId))
                            },
                            onBackToContents = {
                                viewModel.navigateBack()
                            }
                        )
                    }

                    is Screen.MateriSearch -> {
                        MateriSearchScreen(
                            onSubbabClick = { subId ->
                                viewModel.navigateTo(Screen.MateriDetail(subId))
                            },
                            onBackClick = { viewModel.navigateBack() }
                        )
                    }

                    is Screen.Bookmarks -> {
                        BookmarksScreen(
                            bookmarks = bookmarksList,
                            onSubbabClick = { subId ->
                                viewModel.navigateTo(Screen.MateriDetail(subId))
                            },
                            onRemoveBookmark = { subId ->
                                viewModel.toggleBookmark(0, subId, "", "")
                            },
                            onBackClick = { viewModel.navigateBack() }
                        )
                    }

                    is Screen.SoalIntro -> {
                        SoalIntroScreen(
                            initialBabId = screen.babId,
                            onStartQuiz = { babId, isTimer ->
                                viewModel.startQuiz(babId, isTimer)
                            }
                        )
                    }

                    is Screen.SoalActive -> {
                        val quizSoalList by viewModel.quizSoalList.collectAsStateWithLifecycle()
                        val currentIndex by viewModel.quizCurrentIndex.collectAsStateWithLifecycle()
                        val selectedOption by viewModel.quizSelectedOption.collectAsStateWithLifecycle()
                        val isAnswered by viewModel.quizIsAnswered.collectAsStateWithLifecycle()
                        val timeLeftSeconds by viewModel.quizTimeLeftSeconds.collectAsStateWithLifecycle()
                        val isTimerEnabled by viewModel.quizIsTimerEnabled.collectAsStateWithLifecycle()
                        val score by viewModel.quizScore.collectAsStateWithLifecycle()

                        SoalActiveScreen(
                            babId = screen.babId,
                            soalList = quizSoalList,
                            currentIndex = currentIndex,
                            selectedOption = selectedOption,
                            isAnswered = isAnswered,
                            timeLeftSeconds = timeLeftSeconds,
                            isTimerEnabled = isTimerEnabled,
                            score = score,
                            onAnswer = { optIdx -> viewModel.answerQuestion(optIdx) },
                            onSkip = { viewModel.skipQuestion() },
                            onNext = { viewModel.nextQuestion() }
                        )
                    }

                    is Screen.SoalResult -> {
                        SoalResultScreen(
                            hasil = screen.hasil,
                            onRepeatQuiz = {
                                viewModel.startQuiz(screen.hasil.bab, true)
                            },
                            onReviewQuiz = {
                                viewModel.navigateTo(
                                    Screen.SoalReview(
                                        soalList = screen.soalList,
                                        userAnswers = screen.userAnswers
                                    )
                                )
                            },
                            onBackToHome = {
                                viewModel.navigateTo(Screen.Home, clearStack = true)
                            }
                        )
                    }

                    is Screen.SoalReview -> {
                        SoalReviewScreen(
                            soalList = screen.soalList,
                            userAnswers = screen.userAnswers,
                            onBackClick = { viewModel.navigateBack() }
                        )
                    }

                    is Screen.LkpdList -> {
                        LkpdListScreen(
                            submissions = submissionsList,
                            onLkpdClick = { lkpdId ->
                                viewModel.navigateTo(Screen.LkpdDetail(lkpdId))
                            }
                        )
                    }

                    is Screen.LkpdDetail -> {
                        val existingSub = submissionsList.find { it.babId == screen.lkpdId }
                        LkpdDetailScreen(
                            lkpdId = screen.lkpdId,
                            user = user,
                            existingSubmission = existingSub,
                            onSaveSubmission = { babId, jdl, nama, kls, jwb, isComplete ->
                                viewModel.saveLkpdSubmission(
                                    babId, jdl, nama, kls, jwb, isComplete
                                )
                            },
                            onViewPdf = { lkpdId ->
                                viewModel.navigateTo(Screen.LkpdPdfView(lkpdId))
                            },
                            onBackClick = { viewModel.navigateBack() }
                        )
                    }

                    is Screen.LkpdPdfView -> {
                        val existingSub = submissionsList.find { it.babId == screen.lkpdId }
                        LkpdPdfViewScreen(
                            lkpdId = screen.lkpdId,
                            user = user,
                            submission = existingSub,
                            onBackClick = { viewModel.navigateBack() }
                        )
                    }

                    is Screen.RekapNilai -> {
                        RekapNilaiScreen(
                            user = user,
                            hasilList = hasilList
                        )
                    }

                    is Screen.Profil -> {
                        val darkModeSetting by viewModel.darkMode.collectAsStateWithLifecycle()
                        val reminderEnabled by viewModel.reminderEnabled.collectAsStateWithLifecycle()
                        val reminderHour by viewModel.reminderHour.collectAsStateWithLifecycle()

                        ProfilScreen(
                            user = user,
                            darkMode = darkModeSetting,
                            textScale = textScale,
                            reminderEnabled = reminderEnabled,
                            reminderHour = reminderHour,
                            onUpdateProfile = { n, k, a -> viewModel.updateProfile(n, k, a) },
                            onSetDarkMode = { mode -> viewModel.setDarkMode(mode) },
                            onSetTextScale = { scale -> viewModel.setTextScale(scale) },
                            onSetReminderEnabled = { en -> viewModel.setReminderEnabled(en) },
                            onSetReminderHour = { hr -> viewModel.setReminderHour(hr) },
                            onResetData = { viewModel.resetData() }
                        )
                    }

                    is Screen.LabMarketSim -> {
                        MarketSimulationScreen(
                            onBalancedReached = { viewModel.onMarketSimBalanced() },
                            onBackClick = { viewModel.navigateBack() }
                        )
                    }

                    is Screen.LabFraudDetector -> {
                        FraudDetectorScreen(
                            onFinished = { score, total ->
                                viewModel.onFraudDetectorFinished(score, total)
                            },
                            onBackClick = { viewModel.navigateBack() }
                        )
                    }
                }
            }

            // Celebration Modal Dialog
            celebrationEvent?.let { event ->
                CelebrationDialog(
                    event = event,
                    onDismiss = { viewModel.dismissCelebration() }
                )
            }
        }
    }
}
