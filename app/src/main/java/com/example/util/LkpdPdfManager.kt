package com.example.util

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.graphics.pdf.PdfRenderer
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.os.ParcelFileDescriptor
import android.provider.MediaStore
import android.widget.Toast
import com.example.data.model.LkpdItem
import com.example.data.model.LkpdSubmission
import java.io.File
import java.io.FileOutputStream

object LkpdPdfManager {

    fun generateLkpdPdf(
        context: Context,
        item: LkpdItem,
        submission: LkpdSubmission?
    ): File {
        val pdfDocument = PdfDocument()
        val pageInfo = PdfDocument.PageInfo.Builder(595, 842, 1).create() // A4 size
        val page = pdfDocument.startPage(pageInfo)
        val canvas: Canvas = page.canvas

        val paint = Paint()
        paint.isAntiAlias = true

        // Header Background
        paint.color = Color.rgb(25, 118, 210) // #1976D2
        canvas.drawRect(0f, 0f, 595f, 90f, paint)

        // Header Text
        paint.color = Color.WHITE
        paint.textSize = 14f
        paint.isFakeBoldText = true
        canvas.drawText("SMAN 1 PANGKAJENE DAN KEPULAUAN (SMANSA PANGKEP)", 40f, 32f, paint)

        paint.textSize = 10f
        paint.isFakeBoldText = false
        canvas.drawText("Mata Pelajaran: Ekonomi Kelas X (Fase E, Kurikulum Merdeka)", 40f, 50f, paint)
        canvas.drawText("Guru Pengampu: Nur Halim, S.Pd., Gr.  |  Kepala Sekolah: Syamsul Ardi, S.Pd., M.Pd.", 40f, 66f, paint)

        // Title
        paint.color = Color.rgb(33, 33, 33)
        paint.textSize = 13f
        paint.isFakeBoldText = true
        canvas.drawText(item.judul, 40f, 120f, paint)

        // Student Info Box
        paint.color = Color.rgb(240, 243, 246)
        canvas.drawRoundRect(40f, 135f, 555f, 195f, 6f, 6f, paint)

        paint.color = Color.rgb(55, 71, 79)
        paint.textSize = 9.5f
        paint.isFakeBoldText = true
        val nama = submission?.namaSiswa ?: "Belum diisi"
        val kelas = submission?.kelas ?: "X Cermat"
        val tgl = submission?.tanggal ?: "-"
        canvas.drawText("Nama Siswa  : $nama", 50f, 155f, paint)
        canvas.drawText("Kelas            : $kelas", 50f, 172f, paint)
        canvas.drawText("Tanggal        : $tgl   |  Status: ${submission?.status ?: "Draf"}", 320f, 155f, paint)

        // Study Case
        paint.color = Color.rgb(25, 118, 210)
        paint.textSize = 11f
        paint.isFakeBoldText = true
        canvas.drawText("I. STUDI KASUS KONTEKS PANGKEP", 40f, 220f, paint)

        paint.color = Color.rgb(60, 60, 60)
        paint.textSize = 9f
        paint.isFakeBoldText = false

        // Wrap study case text
        var curY = 238f
        val caseLines = wrapText(item.studiKasus, 80)
        for (line in caseLines.take(6)) {
            canvas.drawText(line, 40f, curY, paint)
            curY += 14f
        }

        // Questions and Answers
        curY += 12f
        paint.color = Color.rgb(25, 118, 210)
        paint.textSize = 11f
        paint.isFakeBoldText = true
        canvas.drawText("II. PERTANYAAN DAN JAWABAN SISWA", 40f, curY, paint)
        curY += 18f

        paint.color = Color.rgb(33, 33, 33)
        val rawAnswers = parseAnswers(submission?.jawaban ?: "")

        item.pertanyaanList.forEachIndexed { idx, q ->
            paint.isFakeBoldText = true
            paint.textSize = 9.5f
            paint.color = Color.rgb(20, 20, 20)
            val qLines = wrapText("${idx + 1}. ${q.pertanyaan}", 75)
            for (ql in qLines) {
                if (curY < 720f) {
                    canvas.drawText(ql, 40f, curY, paint)
                    curY += 13f
                }
            }

            paint.isFakeBoldText = false
            paint.color = Color.rgb(70, 70, 70)
            val ans = rawAnswers.getOrNull(idx) ?: "(Belum ada jawaban siswa)"
            val ansLines = wrapText("Jawaban: $ans", 80)
            for (al in ansLines.take(3)) {
                if (curY < 730f) {
                    canvas.drawText(al, 55f, curY, paint)
                    curY += 13f
                }
            }
            curY += 8f
        }

        // Rubrik Penilaian Footer
        if (curY < 740f) {
            paint.color = Color.rgb(180, 180, 180)
            canvas.drawLine(40f, 740f, 555f, 740f, paint)

            paint.color = Color.rgb(100, 100, 100)
            paint.textSize = 8f
            paint.isFakeBoldText = true
            canvas.drawText("RUBRIK PENILAIAN GURU EKONOMI SMAN 1 PANGKEP:", 40f, 755f, paint)

            paint.isFakeBoldText = false
            var rubrikY = 768f
            item.rubrik.forEach { r ->
                canvas.drawText("• ${r.kriteria} (Maks ${r.skorMaks} Poin): ${r.deskripsi}", 40f, rubrikY, paint)
                rubrikY += 11f
            }
        }

        // Footer note
        paint.textSize = 8f
        paint.color = Color.GRAY
        canvas.drawText("Dicetak mandiri melalui Aplikasi EKONOMIKU - SMAN 1 Pangkep", 40f, 820f, paint)

        pdfDocument.finishPage(page)

        val outputDir = File(context.cacheDir, "lkpd_pdf")
        if (!outputDir.exists()) outputDir.mkdirs()

        val safeName = item.filePdfName.ifBlank { "lkpd_${item.id}.pdf" }
        val outputFile = File(outputDir, safeName)
        val fos = FileOutputStream(outputFile)
        pdfDocument.writeTo(fos)
        fos.close()
        pdfDocument.close()

        return outputFile
    }

    fun renderPdfFirstPage(pdfFile: File): Bitmap? {
        return try {
            val fileDescriptor =
                ParcelFileDescriptor.open(pdfFile, ParcelFileDescriptor.MODE_READ_ONLY)
            val renderer = PdfRenderer(fileDescriptor)
            if (renderer.pageCount > 0) {
                val page = renderer.openPage(0)
                val bitmap = Bitmap.createBitmap(page.width, page.height, Bitmap.Config.ARGB_8888)
                page.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
                page.close()
                renderer.close()
                fileDescriptor.close()
                bitmap
            } else {
                renderer.close()
                fileDescriptor.close()
                null
            }
        } catch (e: Exception) {
            null
        }
    }

    fun downloadPdfToDownloads(context: Context, pdfFile: File, displayName: String): Boolean {
        return try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val values = ContentValues().apply {
                    put(MediaStore.MediaColumns.DISPLAY_NAME, displayName)
                    put(MediaStore.MediaColumns.MIME_TYPE, "application/pdf")
                    put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS)
                }
                val uri = context.contentResolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, values)
                if (uri != null) {
                    context.contentResolver.openOutputStream(uri)?.use { out ->
                        pdfFile.inputStream().use { input ->
                            input.copyTo(out)
                        }
                    }
                    Toast.makeText(context, "PDF berhasil disimpan di folder Download!", Toast.LENGTH_LONG).show()
                    true
                } else {
                    false
                }
            } else {
                val targetDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                if (!targetDir.exists()) targetDir.mkdirs()
                val targetFile = File(targetDir, displayName)
                pdfFile.copyTo(targetFile, overwrite = true)
                Toast.makeText(context, "PDF berhasil disimpan di folder Download!", Toast.LENGTH_LONG).show()
                true
            }
        } catch (e: Exception) {
            Toast.makeText(context, "Gagal mengunduh PDF: ${e.message}", Toast.LENGTH_SHORT).show()
            false
        }
    }

    fun shareSubmission(context: Context, item: LkpdItem, submission: LkpdSubmission?) {
        val nama = submission?.namaSiswa ?: "Siswa"
        val kelas = submission?.kelas ?: "X Cermat"
        val tgl = submission?.tanggal ?: "-"
        val rawAnswers = parseAnswers(submission?.jawaban ?: "")

        val sb = StringBuilder()
        sb.append("*PENGUMPULAN LKPD EKONOMIKU*\n")
        sb.append("*SMAN 1 PANGKAJENE DAN KEPULAUAN*\n")
        sb.append("------------------------------------\n")
        sb.append("Judul: ${item.judul}\n")
        sb.append("Nama Siswa: $nama\n")
        sb.append("Kelas: $kelas\n")
        sb.append("Tanggal: $tgl\n")
        sb.append("Guru Pengampu: Nur Halim, S.Pd., Gr.\n")
        sb.append("------------------------------------\n\n")

        item.pertanyaanList.forEachIndexed { idx, q ->
            sb.append("*Soal ${idx + 1}:* ${q.pertanyaan}\n")
            val ans = rawAnswers.getOrNull(idx) ?: "-"
            sb.append("*Jawaban:* $ans\n\n")
        }

        sb.append("Dikirim dari Aplikasi Pembelajaran EKONOMIKU")

        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, sb.toString())
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, "Kumpulkan LKPD via:")
        context.startActivity(shareIntent)
    }

    fun parseAnswers(raw: String): List<String> {
        if (raw.isBlank()) return emptyList()
        return raw.split("|||--SPLIT--|||")
    }

    fun serializeAnswers(answers: List<String>): String {
        return answers.joinToString("|||--SPLIT--|||")
    }

    private fun wrapText(text: String, maxCharsPerLine: Int): List<String> {
        val words = text.split(" ")
        val lines = mutableListOf<String>()
        var currentLine = StringBuilder()

        for (word in words) {
            if (currentLine.length + word.length + 1 > maxCharsPerLine) {
                lines.add(currentLine.toString())
                currentLine = StringBuilder(word)
            } else {
                if (currentLine.isNotEmpty()) currentLine.append(" ")
                currentLine.append(word)
            }
        }
        if (currentLine.isNotEmpty()) {
            lines.add(currentLine.toString())
        }
        return lines
    }
}
