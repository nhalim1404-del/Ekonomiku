package com.example.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.HasilLatihan
import com.example.data.model.User
import com.example.ui.theme.AccentAmber
import com.example.ui.theme.AccentAmberDark
import com.example.ui.theme.PrimaryBlue
import com.example.ui.theme.PrimaryBlueDark

@Composable
fun HomeScreen(
    user: User?,
    hasilList: List<HasilLatihan>,
    readSubbabsCount: Int,
    completedLkpdCount: Int,
    onNavigateToMateri: (semester: Int) -> Unit,
    onNavigateToSoal: (babId: Int) -> Unit,
    onNavigateToLkpd: () -> Unit,
    onNavigateToRekap: () -> Unit,
    onNavigateToProfil: () -> Unit,
    onNavigateToMarketSim: () -> Unit,
    onNavigateToFraudDetector: () -> Unit
) {
    val xp = user?.xp ?: 0
    val level = user?.level ?: 1
    val nama = user?.nama ?: "Siswa SMANSA"
    val kelas = user?.kelas ?: "X Cermat"

    // Level progress calculation
    val (minXp, maxXp) = when (level) {
        1 -> 0 to 100
        2 -> 101 to 300
        3 -> 301 to 600
        4 -> 601 to 1000
        else -> 1001 to 1500
    }
    val levelProgress = if (maxXp > minXp) {
        ((xp - minXp).toFloat() / (maxXp - minXp).toFloat()).coerceIn(0f, 1f)
    } else 1f

    val levelTitle = when (level) {
        1 -> "Calon Ekonom Pemula"
        2 -> "Pembelajar Aktif"
        3 -> "Pengamat Pasar Cermat"
        4 -> "Analis Ekonomi Muda"
        else -> "Master Ekonomi SMANSA"
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .testTag("home_screen"),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(8.dp))
            // Greeting Banner
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Halo, $nama! 👋",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Text(
                        text = "Kelas $kelas • Fase E Kurikulum Merdeka",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        // Gamification Card
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("home_gamification_banner"),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Brush.linearGradient(
                                colors = listOf(PrimaryBlue, PrimaryBlueDark)
                            )
                        )
                        .padding(18.dp)
                ) {
                    Column {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .size(46.dp)
                                        .background(AccentAmber, CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.WorkspacePremium,
                                        contentDescription = "Badge",
                                        tint = Color(0xFF6B4500),
                                        modifier = Modifier.size(28.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.width(12.dp))
                                Column {
                                    Text(
                                        text = "Level $level",
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = AccentAmber
                                    )
                                    Text(
                                        text = levelTitle,
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Color.White
                                    )
                                }
                            }

                            // XP Total
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = Color.White.copy(alpha = 0.2f)
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "XP",
                                        tint = AccentAmber,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = "$xp XP",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 13.sp,
                                        color = Color.White
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        // Progress Bar to Next Level
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Progres Menuju Level ${if (level < 5) level + 1 else 5}",
                                fontSize = 11.sp,
                                color = Color.White.copy(alpha = 0.85f)
                            )
                            Text(
                                text = "$xp / $maxXp XP",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = AccentAmber
                            )
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        LinearProgressIndicator(
                            progress = { levelProgress },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(8.dp)
                                .clip(RoundedCornerShape(4.dp)),
                            color = AccentAmber,
                            trackColor = Color.White.copy(alpha = 0.25f)
                        )
                    }
                }
            }
        }

        // Section: 5 Main Menus
        item {
            Text(
                text = "Menu Pembelajaran",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(10.dp))

            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    MainMenuCard(
                        title = "Materi Interaktif",
                        subtitle = "6 Bab Lengkap (Fase E)",
                        icon = Icons.Default.MenuBook,
                        color = PrimaryBlue,
                        modifier = Modifier.weight(1f),
                        testTag = "home_menu_materi",
                        onClick = { onNavigateToMateri(1) }
                    )
                    MainMenuCard(
                        title = "Latihan Soal",
                        subtitle = "150 Soal + Pembahasan",
                        icon = Icons.Default.Quiz,
                        color = Color(0xFFE65100),
                        modifier = Modifier.weight(1f),
                        testTag = "home_menu_soal",
                        onClick = { onNavigateToSoal(1) }
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    MainMenuCard(
                        title = "LKPD Digital",
                        subtitle = "6 Kasus Nyata Pangkep",
                        icon = Icons.Default.Assignment,
                        color = Color(0xFF00897B),
                        modifier = Modifier.weight(1f),
                        testTag = "home_menu_lkpd",
                        onClick = onNavigateToLkpd
                    )
                    MainMenuCard(
                        title = "Rekap Nilai",
                        subtitle = "Grafik & Riwayat Skor",
                        icon = Icons.Default.BarChart,
                        color = Color(0xFF7B1FA2),
                        modifier = Modifier.weight(1f),
                        testTag = "home_menu_rekap",
                        onClick = onNavigateToRekap
                    )
                }
            }
        }

        // Section: Lab Interaktif (Mini Games)
        item {
            Text(
                text = "Lab Interaktif Ekonomi 🧪",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(8.dp))

            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                InteractiveLabCard(
                    title = "Simulasi Keseimbangan Pasar",
                    desc = "Geser slider harga (P) dan temukan ekuilibrium Qd = 200 - 2P dan Qs = -40 + 4P (+30 XP)",
                    icon = Icons.Default.Timeline,
                    badge = "Mini Game",
                    color = Color(0xFF1976D2),
                    testTag = "home_lab_market",
                    onClick = onNavigateToMarketSim
                )
                InteractiveLabCard(
                    title = "Detektor Fraud & Anti-Pinjol",
                    desc = "Uji ketajaman analisismu mendeteksi investasi bodong & pinjol ilegal dengan prinsip 2L OJK (+30 XP)",
                    icon = Icons.Default.Security,
                    badge = "Simulasi OJK",
                    color = Color(0xFFC2185B),
                    testTag = "home_lab_fraud",
                    onClick = onNavigateToFraudDetector
                )
            }
        }

        // Section: Learning Progress Stats
        item {
            Text(
                text = "Progres Belajarmu",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(8.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    ProgressStatItem(
                        value = "$readSubbabsCount/23",
                        label = "Subbab Dibaca"
                    )
                    ProgressStatItem(
                        value = "${hasilList.size}x",
                        label = "Latihan Selesai"
                    )
                    ProgressStatItem(
                        value = "$completedLkpdCount/6",
                        label = "LKPD Tuntas"
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun MainMenuCard(
    title: String,
    subtitle: String,
    icon: ImageVector,
    color: Color,
    modifier: Modifier = Modifier,
    testTag: String = "",
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .testTag(testTag)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(14.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(color.copy(alpha = 0.15f), RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    tint = color,
                    modifier = Modifier.size(24.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = subtitle,
                fontSize = 10.5.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun InteractiveLabCard(
    title: String,
    desc: String,
    icon: ImageVector,
    badge: String,
    color: Color,
    testTag: String = "",
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .testTag(testTag)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(46.dp)
                    .background(color.copy(alpha = 0.15f), RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    tint = color,
                    modifier = Modifier.size(26.dp)
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = title,
                        fontSize = 13.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Surface(
                        color = color.copy(alpha = 0.12f),
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Text(
                            text = badge,
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            color = color,
                            modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = desc,
                    fontSize = 11.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    lineHeight = 15.sp
                )
            }
        }
    }
}

@Composable
fun ProgressStatItem(value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            fontSize = 18.sp,
            fontWeight = FontWeight.ExtraBold,
            color = PrimaryBlue
        )
        Text(
            text = label,
            fontSize = 10.5.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
