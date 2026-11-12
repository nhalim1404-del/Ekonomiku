package com.example.ui.lkpd

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.PictureAsPdf
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.LkpdSubmission
import com.example.data.model.User
import com.example.data.repository.LkpdData
import com.example.ui.theme.PrimaryBlue
import com.example.ui.theme.SuccessGreen
import com.example.util.LkpdPdfManager
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun LkpdDetailScreen(
    lkpdId: Int,
    user: User?,
    existingSubmission: LkpdSubmission?,
    onSaveSubmission: (babId: Int, judul: String, nama: String, kelas: String, jawaban: String, isCompleted: Boolean) -> Unit,
    onViewPdf: (lkpdId: Int) -> Unit,
    onBackClick: () -> Unit
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val item = LkpdData.getLkpdById(lkpdId) ?: return

    var studentName by remember { mutableStateOf(existingSubmission?.namaSiswa ?: user?.nama ?: "Siswa SMANSA") }
    var studentClass by remember { mutableStateOf(existingSubmission?.kelas ?: user?.kelas ?: "X Cermat") }
    val todayDate = remember {
        existingSubmission?.tanggal ?: SimpleDateFormat("dd/MM/yyyy", Locale("id", "ID")).format(Date())
    }

    val answersMap = remember { mutableStateMapOf<Int, String>() }

    LaunchedEffect(existingSubmission) {
        if (existingSubmission != null) {
            val parsed = LkpdPdfManager.parseAnswers(existingSubmission.jawaban)
            parsed.forEachIndexed { index, ans ->
                answersMap[index] = ans
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .testTag("lkpd_detail_screen")
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
                Text(
                    text = "LKPD Digital Bab ${item.babId}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryBlue
                )
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = item.judul,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = item.deskripsi,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            // Student Identity Form
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Text(
                            text = "Identitas Peserta Didik",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryBlue
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        OutlinedTextField(
                            value = studentName,
                            onValueChange = { studentName = it },
                            label = { Text("Nama Siswa") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("lkpd_input_name")
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            OutlinedTextField(
                                value = studentClass,
                                onValueChange = { studentClass = it },
                                label = { Text("Kelas") },
                                modifier = Modifier
                                    .weight(1f)
                                    .testTag("lkpd_input_class")
                            )
                            OutlinedTextField(
                                value = todayDate,
                                onValueChange = {},
                                label = { Text("Tanggal") },
                                readOnly = true,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }

            // Instructions Card
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(containerColor = PrimaryBlue.copy(alpha = 0.08f))
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Text(
                            text = "Petunjuk Pengerjaan:",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryBlue
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        item.petunjuk.forEach { p ->
                            Text(
                                text = "• $p",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurface,
                                lineHeight = 16.sp
                            )
                        }
                    }
                }
            }

            // Case Study Card
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    border = androidx.compose.foundation.BorderStroke(1.5.dp, PrimaryBlue.copy(alpha = 0.4f))
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "📖 Studi Kasus Kontekstual Pangkep",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryBlue
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = item.studiKasus,
                            fontSize = 12.5.sp,
                            color = MaterialTheme.colorScheme.onSurface,
                            lineHeight = 18.sp
                        )
                    }
                }
            }

            // Questions and Interactive Inputs
            itemsIndexed(item.pertanyaanList) { index, q ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Text(
                            text = "Soal Analisis ${index + 1}:",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryBlue
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = q.pertanyaan,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurface,
                            lineHeight = 18.sp
                        )
                        if (q.hint.isNotBlank()) {
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Petunjuk: ${q.hint}",
                                fontSize = 10.5.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        OutlinedTextField(
                            value = answersMap[index] ?: "",
                            onValueChange = { answersMap[index] = it },
                            placeholder = { Text("Tuliskan uraian analisis jawabanmu di sini...", fontSize = 12.sp) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("lkpd_answer_$index"),
                            minLines = 3,
                            shape = RoundedCornerShape(8.dp)
                        )
                    }
                }
            }

            // Rubrik Penilaian
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Text(
                            text = "Rubrik Penilaian Guru",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        item.rubrik.forEach { r ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 2.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "• ${r.kriteria}: ${r.deskripsi}",
                                    fontSize = 11.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    modifier = Modifier.weight(1f)
                                )
                                Text(
                                    text = "${r.skorMaks} Poin",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = PrimaryBlue
                                )
                            }
                        }
                    }
                }
            }

            // Action Buttons: Simpan Draf, Buka PDF, Unduh PDF, Kumpulkan LKPD
            item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Helper to get serialized answers
                    val getSerialized = {
                        val list = item.pertanyaanList.mapIndexed { idx, _ ->
                            answersMap[idx] ?: ""
                        }
                        LkpdPdfManager.serializeAnswers(list)
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedButton(
                            onClick = {
                                onSaveSubmission(
                                    item.babId,
                                    item.judul,
                                    studentName,
                                    studentClass,
                                    getSerialized(),
                                    false
                                )
                                Toast.makeText(context, "Draf LKPD tersimpan!", Toast.LENGTH_SHORT).show()
                            },
                            modifier = Modifier
                                .weight(1f)
                                .testTag("btn_save_draft")
                        ) {
                            Icon(imageVector = Icons.Default.Save, contentDescription = "Simpan", modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Simpan Draf", fontSize = 11.sp)
                        }

                        OutlinedButton(
                            onClick = {
                                onViewPdf(item.id)
                            },
                            modifier = Modifier
                                .weight(1f)
                                .testTag("btn_open_pdf")
                        ) {
                            Icon(imageVector = Icons.Default.PictureAsPdf, contentDescription = "Buka PDF", modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Buka PDF", fontSize = 11.sp)
                        }
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedButton(
                            onClick = {
                                val currentSub = LkpdSubmission(
                                    babId = item.babId,
                                    judulLkpd = item.judul,
                                    namaSiswa = studentName,
                                    kelas = studentClass,
                                    tanggal = todayDate,
                                    jawaban = getSerialized()
                                )
                                val pdfFile = LkpdPdfManager.generateLkpdPdf(context, item, currentSub)
                                val safeName = "LKPD_${item.babId}_${studentName.replace(" ", "_")}.pdf"
                                LkpdPdfManager.downloadPdfToDownloads(context, pdfFile, safeName)
                            },
                            modifier = Modifier
                                .weight(1f)
                                .testTag("btn_download_pdf")
                        ) {
                            Icon(imageVector = Icons.Default.Download, contentDescription = "Unduh", modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Unduh PDF", fontSize = 11.sp)
                        }

                        Button(
                            onClick = {
                                onSaveSubmission(
                                    item.babId,
                                    item.judul,
                                    studentName,
                                    studentClass,
                                    getSerialized(),
                                    true
                                )
                                val currentSub = LkpdSubmission(
                                    babId = item.babId,
                                    judulLkpd = item.judul,
                                    namaSiswa = studentName,
                                    kelas = studentClass,
                                    tanggal = todayDate,
                                    jawaban = getSerialized(),
                                    status = "Selesai"
                                )
                                LkpdPdfManager.shareSubmission(context, item, currentSub)
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = SuccessGreen),
                            modifier = Modifier
                                .weight(1f)
                                .testTag("btn_submit_lkpd")
                        ) {
                            Icon(imageVector = Icons.Default.Send, contentDescription = "Kumpulkan", modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Kumpulkan (+50 XP)", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}
