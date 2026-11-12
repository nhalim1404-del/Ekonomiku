package com.example.ui.soal

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.Soal
import com.example.ui.theme.AccentAmber
import com.example.ui.theme.ErrorRed
import com.example.ui.theme.PrimaryBlue
import com.example.ui.theme.SuccessGreen

@Composable
fun SoalActiveScreen(
    babId: Int,
    soalList: List<Soal>,
    currentIndex: Int,
    selectedOption: Int?,
    isAnswered: Boolean,
    timeLeftSeconds: Int,
    isTimerEnabled: Boolean,
    score: Int,
    onAnswer: (Int) -> Unit,
    onSkip: () -> Unit,
    onNext: () -> Unit
) {
    val currentSoal = soalList.getOrNull(currentIndex) ?: return
    val totalSoal = soalList.size

    val progress = (currentIndex + 1).toFloat() / totalSoal.toFloat()
    val timerProgress = (timeLeftSeconds.toFloat() / 60f).coerceIn(0f, 1f)
    val optionLabels = listOf("A", "B", "C", "D", "E")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .testTag("soal_active_screen")
    ) {
        // Top Bar: Progress and Timer
        Surface(
            tonalElevation = 3.dp,
            color = MaterialTheme.colorScheme.surface
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Soal ${currentIndex + 1} dari $totalSoal",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = PrimaryBlue
                    )

                    if (isTimerEnabled) {
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = if (timeLeftSeconds <= 10) ErrorRed.copy(alpha = 0.15f) else PrimaryBlue.copy(alpha = 0.1f)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Timer,
                                    contentDescription = "Waktu",
                                    tint = if (timeLeftSeconds <= 10) ErrorRed else PrimaryBlue,
                                    modifier = Modifier.size(15.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "${timeLeftSeconds}s",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.sp,
                                    color = if (timeLeftSeconds <= 10) ErrorRed else PrimaryBlue
                                )
                            }
                        }
                    } else {
                        Text(
                            text = "Bab $babId",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                Spacer(modifier = Modifier.height(6.dp))
                LinearProgressIndicator(
                    progress = { progress },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp),
                    color = PrimaryBlue,
                    trackColor = PrimaryBlue.copy(alpha = 0.2f)
                )

                if (isTimerEnabled && !isAnswered) {
                    Spacer(modifier = Modifier.height(3.dp))
                    LinearProgressIndicator(
                        progress = { timerProgress },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(3.dp),
                        color = if (timeLeftSeconds <= 10) ErrorRed else AccentAmber,
                        trackColor = Color.Transparent
                    )
                }
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // Question Text Card
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = currentSoal.pertanyaan,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurface,
                            lineHeight = 22.sp
                        )
                    }
                }
            }

            // Options A..E
            item {
                Text(
                    text = "Pilih Salah Satu Jawaban:",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(8.dp))

                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    currentSoal.opsi.forEachIndexed { optIdx, optionText ->
                        val isThisSelected = selectedOption == optIdx
                        val isCorrectOption = optIdx == currentSoal.jawabanBenar

                        // Determine background and border colors based on answered state
                        val (containerColor, borderColor, iconTint) = when {
                            !isAnswered && isThisSelected -> Triple(
                                PrimaryBlue.copy(alpha = 0.12f),
                                PrimaryBlue,
                                PrimaryBlue
                            )
                            isAnswered && isCorrectOption -> Triple(
                                SuccessGreen.copy(alpha = 0.15f),
                                SuccessGreen,
                                SuccessGreen
                            )
                            isAnswered && isThisSelected && !isCorrectOption -> Triple(
                                ErrorRed.copy(alpha = 0.15f),
                                ErrorRed,
                                ErrorRed
                            )
                            else -> Triple(
                                MaterialTheme.colorScheme.surface,
                                MaterialTheme.colorScheme.outlineVariant,
                                MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable(enabled = !isAnswered) { onAnswer(optIdx) }
                                .testTag("option_${optionLabels[optIdx]}"),
                            shape = RoundedCornerShape(10.dp),
                            color = containerColor,
                            border = androidx.compose.foundation.BorderStroke(1.5.dp, borderColor)
                        ) {
                            Row(
                                modifier = Modifier.padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(30.dp)
                                        .background(borderColor, CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = optionLabels[optIdx],
                                        color = if (isAnswered && (isCorrectOption || isThisSelected)) Color.White else Color.White,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 13.sp
                                    )
                                }
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(
                                    text = optionText,
                                    fontSize = 13.sp,
                                    fontWeight = if (isThisSelected || (isAnswered && isCorrectOption)) FontWeight.Bold else FontWeight.Normal,
                                    color = MaterialTheme.colorScheme.onSurface,
                                    modifier = Modifier.weight(1f)
                                )

                                if (isAnswered) {
                                    if (isCorrectOption) {
                                        Icon(
                                            imageVector = Icons.Default.CheckCircle,
                                            contentDescription = "Benar",
                                            tint = SuccessGreen,
                                            modifier = Modifier.size(20.dp)
                                        )
                                    } else if (isThisSelected) {
                                        Icon(
                                            imageVector = Icons.Default.Close,
                                            contentDescription = "Salah",
                                            tint = ErrorRed,
                                            modifier = Modifier.size(20.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // Instant Feedback Card (when answered)
            if (isAnswered) {
                item {
                    val wasCorrect = selectedOption == currentSoal.jawabanBenar
                    val feedbackColor = if (wasCorrect) SuccessGreen else ErrorRed
                    val feedbackTitle = if (wasCorrect) "Jawaban Benar! (+10 XP)" else "Jawaban Kurang Tepat!"

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp),
                        colors = CardDefaults.cardColors(containerColor = feedbackColor.copy(alpha = 0.08f)),
                        border = androidx.compose.foundation.BorderStroke(1.5.dp, feedbackColor.copy(alpha = 0.6f))
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = if (wasCorrect) Icons.Default.CheckCircle else Icons.Default.Close,
                                    contentDescription = null,
                                    tint = feedbackColor,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = feedbackTitle,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = feedbackColor
                                )
                            }
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = "Kunci Jawaban: ${optionLabels[currentSoal.jawabanBenar]}. ${currentSoal.opsi[currentSoal.jawabanBenar]}",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Pembahasan: ${currentSoal.pembahasan}",
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                lineHeight = 17.sp
                            )
                        }
                    }
                }
            }

            // Action Buttons
            item {
                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    if (!isAnswered) {
                        OutlinedButton(
                            onClick = onSkip,
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp)
                                .testTag("btn_skip_question")
                        ) {
                            Icon(imageVector = Icons.Default.SkipNext, contentDescription = "Lewati")
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Lewati Soal")
                        }
                    } else {
                        Button(
                            onClick = onNext,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .testTag("btn_next_question"),
                            colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(
                                text = if (currentIndex + 1 < totalSoal) "Soal Berikutnya" else "Lihat Hasil Latihan",
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Lanjut")
                        }
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}
