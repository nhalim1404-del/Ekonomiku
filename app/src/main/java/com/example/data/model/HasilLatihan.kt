package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hasil_latihan")
data class HasilLatihan(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val userId: Int = 1,
    val bab: Int,
    val judulBab: String,
    val skor: Int,
    val totalSoal: Int = 25,
    val persentase: Int,
    val predikat: String,
    val tanggal: String,
    val waktuDetik: Int
)
