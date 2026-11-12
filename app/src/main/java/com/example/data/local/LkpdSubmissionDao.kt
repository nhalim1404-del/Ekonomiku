package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.LkpdSubmission
import kotlinx.coroutines.flow.Flow

@Dao
interface LkpdSubmissionDao {
    @Query("SELECT * FROM lkpd_submissions WHERE babId = :babId LIMIT 1")
    fun getSubmissionByBab(babId: Int): Flow<LkpdSubmission?>

    @Query("SELECT * FROM lkpd_submissions ORDER BY id DESC")
    fun getAllSubmissions(): Flow<List<LkpdSubmission>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(submission: LkpdSubmission): Long

    @Query("DELETE FROM lkpd_submissions")
    suspend fun deleteAll()
}
