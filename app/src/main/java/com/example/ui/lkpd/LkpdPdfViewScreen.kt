package com.example.ui.lkpd

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Download
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.LkpdSubmission
import com.example.data.model.User
import com.example.data.repository.LkpdData
import com.example.ui.theme.PrimaryBlue
import com.example.util.LkpdPdfManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun LkpdPdfViewScreen(
    lkpdId: Int,
    user: User?,
    submission: LkpdSubmission?,
    onBackClick: () -> Unit
) {
    val context = LocalContext.current
    val item = LkpdData.getLkpdById(lkpdId) ?: return

    var renderedBitmap by remember { mutableStateOf<Bitmap?>(null) }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(lkpdId) {
        withContext(Dispatchers.IO) {
            val pdfFile = LkpdPdfManager.generateLkpdPdf(context, item, submission)
            val bmp = LkpdPdfManager.renderPdfFirstPage(pdfFile)
            renderedBitmap = bmp
            isLoading = false
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .testTag("lkpd_pdf_view_screen")
    ) {
        Surface(
            tonalElevation = 2.dp,
            color = MaterialTheme.colorScheme.surface
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Kembali")
                }
                Spacer(modifier = Modifier.width(6.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "PDF Viewer: ${item.judul}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = PrimaryBlue,
                        maxLines = 1
                    )
                    Text(
                        text = "Android PdfRenderer Internal",
                        fontSize = 10.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                IconButton(
                    onClick = {
                        val pdfFile = LkpdPdfManager.generateLkpdPdf(context, item, submission)
                        val name = submission?.namaSiswa ?: "Siswa"
                        val safeName = "LKPD_${item.babId}_${name.replace(" ", "_")}.pdf"
                        LkpdPdfManager.downloadPdfToDownloads(context, pdfFile, safeName)
                    }
                ) {
                    Icon(imageVector = Icons.Default.Download, contentDescription = "Unduh PDF", tint = PrimaryBlue)
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF424242))
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            if (isLoading) {
                CircularProgressIndicator(color = Color.White)
            } else if (renderedBitmap != null) {
                Surface(
                    shape = RoundedCornerShape(4.dp),
                    shadowElevation = 8.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, Color.LightGray, RoundedCornerShape(4.dp))
                ) {
                    Image(
                        bitmap = renderedBitmap!!.asImageBitmap(),
                        contentDescription = "Halaman Dokumen LKPD",
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.FillWidth
                    )
                }
            } else {
                Text(
                    text = "Gagal memuat dokumen PDF. Format dokumen tetap dapat diunduh.",
                    color = Color.White,
                    fontSize = 13.sp
                )
            }
        }
    }
}
