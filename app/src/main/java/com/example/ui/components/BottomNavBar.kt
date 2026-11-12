package com.example.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.PrimaryBlue
import com.example.ui.viewmodel.Screen

enum class BottomTab(val title: String, val icon: ImageVector) {
    HOME("Home", Icons.Default.Home),
    MATERI("Materi", Icons.Default.MenuBook),
    SOAL("Soal", Icons.Default.Quiz),
    LKPD("LKPD", Icons.Default.Assignment),
    REKAP("Rekap", Icons.Default.BarChart),
    PROFIL("Profil", Icons.Default.Person)
}

@Composable
fun AppBottomNavBar(
    currentScreen: Screen,
    onTabSelected: (BottomTab) -> Unit,
    modifier: Modifier = Modifier
) {
    val selectedTab = when (currentScreen) {
        is Screen.Home, is Screen.LabMarketSim, is Screen.LabFraudDetector -> BottomTab.HOME
        is Screen.MateriList, is Screen.MateriDetail, is Screen.MateriSearch, is Screen.Bookmarks -> BottomTab.MATERI
        is Screen.SoalIntro, is Screen.SoalActive, is Screen.SoalResult, is Screen.SoalReview -> BottomTab.SOAL
        is Screen.LkpdList, is Screen.LkpdDetail, is Screen.LkpdPdfView -> BottomTab.LKPD
        is Screen.RekapNilai -> BottomTab.REKAP
        is Screen.Profil -> BottomTab.PROFIL
        else -> BottomTab.HOME
    }

    NavigationBar(
        modifier = modifier.testTag("app_bottom_nav_bar"),
        tonalElevation = 4.dp,
        containerColor = MaterialTheme.colorScheme.surface
    ) {
        BottomTab.values().forEach { tab ->
            val isSelected = tab == selectedTab
            NavigationBarItem(
                selected = isSelected,
                onClick = { onTabSelected(tab) },
                icon = {
                    Icon(
                        imageVector = tab.icon,
                        contentDescription = tab.title
                    )
                },
                label = {
                    Text(
                        text = tab.title,
                        fontSize = 10.sp,
                        maxLines = 1
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = PrimaryBlue,
                    selectedTextColor = PrimaryBlue,
                    indicatorColor = PrimaryBlue.copy(alpha = 0.15f),
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                ),
                modifier = Modifier.testTag("nav_tab_${tab.name.lowercase()}")
            )
        }
    }
}
