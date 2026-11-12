package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey
    val id: Int = 1,
    val nama: String = "Siswa SMANSA",
    val kelas: String = "X Cermat",
    val avatarId: Int = 1,
    val xp: Int = 0,
    val level: Int = 1,
    val lencanaTerbuka: String = "", // Comma-separated badge IDs
    val tanggalDaftar: String = ""
)
