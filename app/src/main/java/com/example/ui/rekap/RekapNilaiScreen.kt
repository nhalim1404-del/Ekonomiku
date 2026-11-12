package com.example.ui.rekap

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.HasilLatihan
import com.example.data.model.User
import com.example.ui.theme.ErrorRed
import com.example.ui.theme.PrimaryBlue
import com.example.ui.theme.SuccessGreen

@Composable
fun RekapNilaiScreen(
    user: User?,
    hasilList: List<HasilLatihan>
) {
    val context = LocalContext.current
    var selectedBabFilter by remember { mutableIntStateOf(0) } // 0 = Semua Bab

    val filteredList = remember(hasilList, selectedBabFilter) {
        if (selectedBabFilter == 0) hasilList
        else hasilList.filter { it.bab == selectedBabFilter }
    }

    val averageScore = remember(hasilList) {
        if (hasilList.isNotEmpty()) hasilList.map { it.persentase }.average().toInt() else 0
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .testTag("rekap_nilai_screen")
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = "Rekap Nilai Siswa",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.ExtraBold,
                            color = PrimaryBlue
                        )
                        Text(
                            text = "Catatan kemajuan belajar & skor latihan soal",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    Button(
                        onClick = {
                            exportRekapText(context, user, hasilList)
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.testTag("btn_export_rekap")
                    ) {
                        Icon(imageVector = Icons.Default.Share, contentDescription = "Ekspor", modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Ekspor", fontSize = 12.sp)
                    }
                }
            }

            // Overview Summary Card
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        SummaryPill(title = "Total Latihan", value = "${hasilList.size} Kali")
                        SummaryPill(title = "Rata-Rata Nilai", value = "$averageScore%", color = PrimaryBlue)
                        SummaryPill(
                            title = "Nilai Tertinggi",
                            value = "${hasilList.maxOfOrNull { it.persentase } ?: 0}%",
                            color = SuccessGreen
                        )
                    }
                }
            }

            // Progress Chart by Chapter (Bab 1..6)
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(imageVector = Icons.Default.BarChart, contentDescription = null, tint = PrimaryBlue, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "Grafik Rata-Rata Nilai per Bab",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        ScoreBarChart(hasilList = hasilList)
                    }
                }
            }

            // Filter Chips (Semua, Bab 1, Bab 2, ..., Bab 6)
            item {
                Text(
                    text = "Filter Berdasarkan Bab:",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(6.dp))
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    item {
                        FilterChip(
                            selected = selectedBabFilter == 0,
                            onClick = { selectedBabFilter = 0 },
                            label = { Text("Semua Bab") }
                        )
                    }
                    items(6) { index ->
                        val bId = index + 1
                        FilterChip(
                            selected = selectedBabFilter == bId,
                            onClick = { selectedBabFilter = bId },
                            label = { Text("Bab $bId") }
                        )
                    }
                }
            }

            // History List
            if (filteredList.isEmpty()) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 24.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Belum ada riwayat latihan pada filter ini.",
                            fontSize = 13.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            } else {
                items(filteredList) { item ->
                    HasilLatihanRowItem(hasil = item)
                }
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun ScoreBarChart(hasilList: List<HasilLatihan>) {
    val babAverages = (1..6).map { babId ->
        val list = hasilList.filter { it.bab == babId }
        if (list.isNotEmpty()) list.map { it.persentase }.average().toFloat() else 0f
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.25f), RoundedCornerShape(8.dp))
            .padding(8.dp)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val w = size.width
            val h = size.height
            val slotWidth = w / 6f
            val barWidth = slotWidth * 0.45f

            babAverages.forEachIndexed { idx, avg ->
                val barHeight = (avg / 100f) * (h - 25f)
                val left = (idx * slotWidth) + (slotWidth - barWidth) / 2f
                val top = (h - 20f) - barHeight

                val barColor = when {
                    avg >= 85f -> Color(0xFF2E7D32)
                    avg >= 70f -> Color(0xFF1976D2)
                    avg >= 55f -> Color(0xFFFFA000)
                    avg > 0f -> Color(0xFFD32F2F)
                    else -> Color.LightGray.copy(alpha = 0.4f)
                }

                // Draw Bar
                drawRoundRect(
                    color = barColor,
                    topLeft = Offset(left, top),
                    size = Size(barWidth, barHeight.coerceAtLeast(4f)),
                    cornerRadius = CornerRadius(4f, 4f)
                )
            }
        }

        // Labels under bars
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            (1..6).forEach { bId ->
                Text(
                    text = "B$bId",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
fun HasilLatihanRowItem(hasil: HasilLatihan) {
    val predikatColor = when (hasil.predikat) {
        "Sangat Baik" -> SuccessGreen
        "Baik" -> PrimaryBlue
        "Cukup" -> Color(0xFFF57C00)
        else -> ErrorRed
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = hasil.judulBab,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Tanggal: ${hasil.tanggal}  •  Waktu: ${hasil.waktuDetik} detik",
                    fontSize = 10.5.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Skor: ${hasil.skor}/${hasil.totalSoal} Soal",
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Surface(
                        shape = RoundedCornerShape(4.dp),
                        color = predikatColor.copy(alpha = 0.12f)
                    ) {
                        Text(
                            text = hasil.predikat,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = predikatColor,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .size(46.dp)
                    .background(predikatColor.copy(alpha = 0.15f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "${hasil.persentase}%",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = predikatColor
                )
            }
        }
    }
}

@Composable
fun SummaryPill(title: String, value: String, color: Color = MaterialTheme.colorScheme.onSurface) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = title, fontSize = 10.5.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
        Spacer(modifier = Modifier.height(2.dp))
        Text(text = value, fontSize = 16.sp, fontWeight = FontWeight.ExtraBold, color = color)
    }
}

private fun exportRekapText(context: Context, user: User?, hasilList: List<HasilLatihan>) {
    val nama = user?.nama ?: "Siswa"
    val kelas = user?.kelas ?: "X Cermat"
    val xp = user?.xp ?: 0
    val level = user?.level ?: 1

    val sb = StringBuilder()
    sb.append("*REKAP KEMAJUAN BELAJAR EKONOMIKU*\n")
    sb.append("*SMAN 1 PANGKAJENE DAN KEPULAUAN*\n")
    sb.append("------------------------------------------\n")
    sb.append("Nama Siswa  : $nama\n")
    sb.append("Kelas       : $kelas\n")
    sb.append("Total XP    : $xp XP (Level $level)\n")
    sb.append("Guru        : Nur Halim, S.Pd., Gr.\n")
    sb.append("------------------------------------------\n\n")
    sb.append("*RIWAYAT LATIHAN SOAL (25 SOAL/BAB):*\n")

    if (hasilList.isEmpty()) {
        sb.append("- Belum ada catatan latihan -\n")
    } else {
        hasilList.forEachIndexed { idx, h ->
            sb.append("${idx + 1}. ${h.judulBab}\n")
            sb.append("   Skor: ${h.skor}/${h.totalSoal} (${h.persentase}%) - ${h.predikat}\n")
            sb.append("   Waktu: ${h.tanggal}\n\n")
        }
    }

    sb.append("Dicetak otomatis melalui Aplikasi EKONOMIKU")

    val intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, sb.toString())
        type = "text/plain"
    }
    context.startActivity(Intent.createChooser(intent, "Bagikan Rekap Nilai via:"))
}
