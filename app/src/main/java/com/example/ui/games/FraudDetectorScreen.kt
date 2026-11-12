package com.example.ui.games

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.repository.LabData
import com.example.ui.theme.ErrorRed
import com.example.ui.theme.PrimaryBlue
import com.example.ui.theme.SuccessGreen

@Composable
fun FraudDetectorScreen(
    onFinished: (score: Int, total: Int) -> Unit,
    onBackClick: () -> Unit
) {
    val scenarios = LabData.fraudScenarios
    val totalScenarios = scenarios.size

    var currentIndex by remember { mutableIntStateOf(0) }
    var userAnswers = remember { mutableStateMapOf<Int, Boolean>() } // scenarioId -> isLegalLogis
    var isAnswered by remember { mutableStateOf(false) }
    var selectedChoice by remember { mutableStateOf<Boolean?>(null) }
    var isSimulationComplete by remember { mutableStateOf(false) }
    var finalScore by remember { mutableIntStateOf(0) }

    val currentScenario = scenarios.getOrNull(currentIndex) ?: return

    Column(
        modifier = Modifier
            .fillMaxSize()
            .testTag("fraud_detector_screen")
    ) {
        Surface(
            tonalElevation = 2.dp,
            color = MaterialTheme.colorScheme.surface
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Kembali")
                }
                Spacer(modifier = Modifier.width(6.dp))
                Column {
                    Text(
                        text = "Detektor Fraud & Anti-Pinjol",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryBlue
                    )
                    Text(
                        text = "Uji literasi keuanganmu berdasar Prinsip 2L OJK",
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        if (isSimulationComplete) {
            // Summary Screen
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                contentAlignment = Alignment.Center
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .size(70.dp)
                                .background(SuccessGreen.copy(alpha = 0.15f), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Security,
                                contentDescription = null,
                                tint = SuccessGreen,
                                modifier = Modifier.size(40.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Simulasi Selesai!",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryBlue
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "Skor Analisis: $finalScore dari $totalScenarios Kasus Benar",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = SuccessGreen
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = if (finalScore >= 4) {
                                "Hebat! Kamu memiliki ketajaman literasi finansial yang tinggi dan mampu melindungi diri dari kejahatan keuangan. (+30 XP)"
                            } else {
                                "Tetap waspada! Pelajari kembali prinsip 2L (Legal dan Logis) agar tidak mudah terjebak investasi bodong. (+30 XP)"
                            },
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                            lineHeight = 17.sp
                        )

                        Spacer(modifier = Modifier.height(20.dp))
                        Button(
                            onClick = onBackClick,
                            colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Selesai & Kembali", fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Progress
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Kasus ${currentIndex + 1} dari $totalScenarios",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp,
                            color = PrimaryBlue
                        )
                        Text(
                            text = "Skor: $finalScore Benar",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = SuccessGreen
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    LinearProgressIndicator(
                        progress = { (currentIndex + 1).toFloat() / totalScenarios.toFloat() },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(6.dp),
                        color = PrimaryBlue
                    )
                }

                // Scenario Card
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .size(30.dp)
                                        .background(PrimaryBlue.copy(alpha = 0.12f), CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Warning,
                                        contentDescription = null,
                                        tint = PrimaryBlue,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = currentScenario.judul,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }

                            Spacer(modifier = Modifier.height(12.dp))
                            Text(
                                text = "Deskripsi Tawaran:",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "\"${currentScenario.tawaran}\"",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Medium,
                                color = MaterialTheme.colorScheme.onSurface,
                                lineHeight = 19.sp
                            )
                        }
                    }
                }

                // Interactive Buttons: Legal & Logis vs Waspada / Fraud
                item {
                    Text(
                        text = "Bagaimana penilaianmu terhadap tawaran di atas?",
                        fontSize = 12.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Button(
                            onClick = {
                                if (!isAnswered) {
                                    isAnswered = true
                                    selectedChoice = true
                                    if (currentScenario.isLegalLogis) finalScore++
                                }
                            },
                            enabled = !isAnswered,
                            colors = ButtonDefaults.buttonColors(containerColor = SuccessGreen),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(52.dp)
                                .testTag("btn_choice_legal")
                        ) {
                            Text("✅ LEGAL & LOGIS\n(Aman)", textAlign = androidx.compose.ui.text.style.TextAlign.Center, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        }

                        Button(
                            onClick = {
                                if (!isAnswered) {
                                    isAnswered = true
                                    selectedChoice = false
                                    if (!currentScenario.isLegalLogis) finalScore++
                                }
                            },
                            enabled = !isAnswered,
                            colors = ButtonDefaults.buttonColors(containerColor = ErrorRed),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(52.dp)
                                .testTag("btn_choice_fraud")
                        ) {
                            Text("🚨 WASPADA / FRAUD\n(Berbahaya)", textAlign = androidx.compose.ui.text.style.TextAlign.Center, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }

                // Feedback
                if (isAnswered) {
                    item {
                        val isUserCorrect = selectedChoice == currentScenario.isLegalLogis
                        val fbColor = if (isUserCorrect) SuccessGreen else ErrorRed

                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp),
                            colors = CardDefaults.cardColors(containerColor = fbColor.copy(alpha = 0.08f)),
                            border = androidx.compose.foundation.BorderStroke(1.5.dp, fbColor.copy(alpha = 0.5f))
                        ) {
                            Column(modifier = Modifier.padding(14.dp)) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = if (isUserCorrect) Icons.Default.CheckCircle else Icons.Default.Close,
                                        contentDescription = null,
                                        tint = fbColor,
                                        modifier = Modifier.size(20.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = if (isUserCorrect) "Analisis Tepat!" else "Analisis Kurang Tepat!",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = fbColor
                                    )
                                }
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = "Status Sebenarnya: ${if (currentScenario.isLegalLogis) "LEGAL & LOGIS" else "WASPADA / FRAUD"}",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = currentScenario.alasan,
                                    fontSize = 11.5.sp,
                                    color = MaterialTheme.colorScheme.onSurface,
                                    lineHeight = 16.sp
                                )
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = "💡 Tips OJK: ${currentScenario.tipsOjk}",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = PrimaryBlue
                                )
                            }
                        }
                    }

                    item {
                        Button(
                            onClick = {
                                if (currentIndex + 1 < totalScenarios) {
                                    currentIndex++
                                    isAnswered = false
                                    selectedChoice = null
                                } else {
                                    isSimulationComplete = true
                                    onFinished(finalScore, totalScenarios)
                                }
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp)
                                .testTag("btn_next_fraud_case")
                        ) {
                            Text(
                                text = if (currentIndex + 1 < totalScenarios) "Lanjut ke Kasus Berikutnya" else "Lihat Skor Akhir",
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    }
}
