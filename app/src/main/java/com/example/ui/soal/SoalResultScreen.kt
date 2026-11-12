package com.example.ui.soal

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
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ListAlt
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.HasilLatihan
import com.example.ui.theme.AccentAmber
import com.example.ui.theme.ErrorRed
import com.example.ui.theme.PrimaryBlue
import com.example.ui.theme.SuccessGreen

@Composable
fun SoalResultScreen(
    hasil: HasilLatihan,
    onRepeatQuiz: () -> Unit,
    onReviewQuiz: () -> Unit,
    onBackToHome: () -> Unit
) {
    val benar = hasil.skor
    val salah = hasil.totalSoal - hasil.skor
    val minutes = hasil.waktuDetik / 60
    val seconds = hasil.waktuDetik % 60
    val waktuStr = "${minutes}m ${seconds}s"

    val predikatColor = when (hasil.predikat) {
        "Sangat Baik" -> SuccessGreen
        "Baik" -> PrimaryBlue
        "Cukup" -> Color(0xFFF57C00)
        else -> ErrorRed
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .testTag("soal_result_screen")
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(10.dp))
                // Trophy Emblem
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .background(AccentAmber.copy(alpha = 0.2f), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.EmojiEvents,
                        contentDescription = "Hasil Latihan",
                        tint = Color(0xFFFFA000),
                        modifier = Modifier.size(50.dp)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Latihan Selesai!",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.ExtraBold,
                    color = PrimaryBlue
                )
                Text(
                    text = hasil.judulBab,
                    fontSize = 13.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            // Score Card
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "${hasil.persentase}%",
                            fontSize = 48.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = predikatColor
                        )

                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = predikatColor.copy(alpha = 0.15f)
                        ) {
                            Text(
                                text = "Predikat: ${hasil.predikat}",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = predikatColor,
                                modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        // Stats Grid
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            ResultStatBox(
                                title = "Benar",
                                value = "$benar Soal",
                                color = SuccessGreen
                            )
                            ResultStatBox(
                                title = "Salah/Lewat",
                                value = "$salah Soal",
                                color = ErrorRed
                            )
                            ResultStatBox(
                                title = "Waktu",
                                value = waktuStr,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }

                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "+${benar * 10} XP telah ditambahkan ke akunmu!",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = AccentAmber
                        )
                    }
                }
            }

            // Action Buttons
            item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Button(
                        onClick = onReviewQuiz,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .testTag("btn_review_quiz"),
                        colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Icon(imageVector = Icons.Default.ListAlt, contentDescription = "Pembahasan")
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Lihat Pembahasan Lengkap (25 Soal)", fontWeight = FontWeight.Bold)
                    }

                    OutlinedButton(
                        onClick = onRepeatQuiz,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .testTag("btn_repeat_quiz"),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Icon(imageVector = Icons.Default.Refresh, contentDescription = "Ulangi")
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Ulangi Latihan Soal")
                    }

                    OutlinedButton(
                        onClick = onBackToHome,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .testTag("btn_back_to_home"),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Kembali ke Beranda")
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun ResultStatBox(title: String, value: String, color: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = title,
            fontSize = 11.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = value,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = color
        )
    }
}
