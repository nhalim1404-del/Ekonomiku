package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmarks")
data class Bookmark(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val babId: Int,
    val subbabId: String,
    val judulBab: String,
    val judulSubbab: String,
    val tanggal: String
)
