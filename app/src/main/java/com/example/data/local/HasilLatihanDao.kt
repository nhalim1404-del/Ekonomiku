package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.HasilLatihan
import kotlinx.coroutines.flow.Flow

@Dao
interface HasilLatihanDao {
    @Query("SELECT * FROM hasil_latihan ORDER BY id DESC")
    fun getAllHasil(): Flow<List<HasilLatihan>>

    @Query("SELECT * FROM hasil_latihan WHERE bab = :bab ORDER BY id DESC")
    fun getHasilByBab(bab: Int): Flow<List<HasilLatihan>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(hasil: HasilLatihan): Long

    @Query("DELETE FROM hasil_latihan")
    suspend fun deleteAll()
}
