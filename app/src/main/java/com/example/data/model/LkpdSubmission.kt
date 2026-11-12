package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lkpd_submissions")
data class LkpdSubmission(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val babId: Int,
    val judulLkpd: String,
    val namaSiswa: String,
    val kelas: String,
    val tanggal: String,
    val jawaban: String, // Formatted text or JSON of answers
    val status: String = "Draf", // "Draf" or "Selesai"
    val tanggalSimpan: String = ""
)
