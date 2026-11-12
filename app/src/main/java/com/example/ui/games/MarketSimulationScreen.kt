package com.example.ui.games

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.AccentAmber
import com.example.ui.theme.ErrorRed
import com.example.ui.theme.PrimaryBlue
import com.example.ui.theme.SuccessGreen
import kotlin.math.roundToInt

@Composable
fun MarketSimulationScreen(
    onBalancedReached: () -> Unit,
    onBackClick: () -> Unit
) {
    var priceP by remember { mutableFloatStateOf(25f) } // Slider 10..70
    var hasClaimedXp by remember { mutableStateOf(false) }

    val pInt = priceP.roundToInt()
    val qd = 200 - 2 * pInt
    val qs = -40 + 4 * pInt

    val isEquilibrium = pInt == 40
    val isShortage = pInt < 40
    val isSurplus = pInt > 40

    val statusTitle = when {
        isEquilibrium -> "Keseimbangan Pasar Tercipta! (Ekuilibrium)"
        isShortage -> "Kelebihan Permintaan (Excess Demand / Shortage)"
        else -> "Kelebihan Penawaran (Excess Supply / Surplus)"
    }

    val statusColor = when {
        isEquilibrium -> SuccessGreen
        isShortage -> Color(0xFFF57C00)
        else -> PrimaryBlue
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .testTag("market_simulation_screen")
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
                        text = "Simulasi Keseimbangan Pasar",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryBlue
                    )
                    Text(
                        text = "Geser harga P dan temukan titik ekuilibrium",
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
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
            // Formula info
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(containerColor = PrimaryBlue.copy(alpha = 0.08f))
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                            text = "Model Persamaan Pasar:",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryBlue
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "• Fungsi Permintaan: Qd = 200 - 2P\n• Fungsi Penawaran: Qs = -40 + 4P",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }

            // Interactive Graph Box
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(14.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Visualisasi Kurva D dan S",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(160.dp)
                                .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.25f), RoundedCornerShape(8.dp))
                                .padding(8.dp)
                        ) {
                            Canvas(modifier = Modifier.fillMaxSize()) {
                                val w = size.width
                                val h = size.height

                                // Axes
                                drawLine(color = Color.Gray, start = Offset(30f, 10f), end = Offset(30f, h - 20f), strokeWidth = 2.5f)
                                drawLine(color = Color.Gray, start = Offset(30f, h - 20f), end = Offset(w - 10f, h - 20f), strokeWidth = 2.5f)

                                // Demand Curve (D)
                                drawLine(color = Color(0xFFD32F2F), start = Offset(40f, 20f), end = Offset(w - 20f, h - 30f), strokeWidth = 3f)
                                // Supply Curve (S)
                                drawLine(color = Color(0xFF1976D2), start = Offset(40f, h - 30f), end = Offset(w - 20f, 20f), strokeWidth = 3f)

                                // Current Price Line
                                val normalizedP = (priceP - 10f) / (70f - 10f)
                                val currentY = (h - 25f) - (normalizedP * (h - 45f))
                                drawLine(
                                    color = statusColor,
                                    start = Offset(30f, currentY),
                                    end = Offset(w - 15f, currentY),
                                    strokeWidth = 2f
                                )

                                // Current Dynamic Equilibrium Dot
                                val midX = (40f + w - 20f) / 2f
                                val midY = (20f + h - 30f) / 2f
                                drawCircle(
                                    color = if (isEquilibrium) SuccessGreen else AccentAmber,
                                    radius = if (isEquilibrium) 8f else 5f,
                                    center = Offset(midX, midY)
                                )
                            }
                        }
                    }
                }
            }

            // Slider Controls
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Tingkat Harga Pasar (P):",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "Rp$pInt",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = PrimaryBlue
                            )
                        }

                        Slider(
                            value = priceP,
                            onValueChange = { priceP = it },
                            valueRange = 10f..70f,
                            steps = 59,
                            modifier = Modifier.fillMaxWidth(),
                            colors = SliderDefaults.colors(
                                thumbColor = PrimaryBlue,
                                activeTrackColor = PrimaryBlue
                            )
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("Rp10 (Murah)", fontSize = 10.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            Text("Rp40 (Target Ekuilibrium)", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = AccentAmber)
                            Text("Rp70 (Mahal)", fontSize = 10.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }
                }
            }

            // Real-time Calculations Card
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    border = androidx.compose.foundation.BorderStroke(1.5.dp, statusColor.copy(alpha = 0.6f))
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = if (isEquilibrium) Icons.Default.CheckCircle else Icons.Default.Info,
                                contentDescription = null,
                                tint = statusColor,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = statusTitle,
                                fontSize = 13.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = statusColor
                            )
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("Permintaan (Qd)", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                Text("$qd Unit", fontSize = 18.sp, fontWeight = FontWeight.ExtraBold, color = Color(0xFFD32F2F))
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("Penawaran (Qs)", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                Text("$qs Unit", fontSize = 18.sp, fontWeight = FontWeight.ExtraBold, color = Color(0xFF1976D2))
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("Selisih", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                val diff = kotlin.math.abs(qd - qs)
                                Text(
                                    text = "$diff Unit",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = if (isEquilibrium) SuccessGreen else MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }

                        if (isEquilibrium && !hasClaimedXp) {
                            Spacer(modifier = Modifier.height(14.dp))
                            Button(
                                onClick = {
                                    hasClaimedXp = true
                                    onBalancedReached()
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = SuccessGreen),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .testTag("btn_claim_equilibrium_xp")
                            ) {
                                Icon(imageVector = Icons.Default.CheckCircle, contentDescription = null)
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("Klaim Prestasi Ekuilibrium (+30 XP)", fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}
