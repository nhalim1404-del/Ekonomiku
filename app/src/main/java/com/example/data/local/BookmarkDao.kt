package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.Bookmark
import kotlinx.coroutines.flow.Flow

@Dao
interface BookmarkDao {
    @Query("SELECT * FROM bookmarks ORDER BY id DESC")
    fun getAllBookmarks(): Flow<List<Bookmark>>

    @Query("SELECT EXISTS(SELECT 1 FROM bookmarks WHERE subbabId = :subbabId)")
    fun isBookmarked(subbabId: String): Flow<Boolean>

    @Query("SELECT EXISTS(SELECT 1 FROM bookmarks WHERE subbabId = :subbabId)")
    suspend fun isBookmarkedSync(subbabId: String): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(bookmark: Bookmark): Long

    @Query("DELETE FROM bookmarks WHERE subbabId = :subbabId")
    suspend fun deleteBySubbabId(subbabId: String)

    @Query("DELETE FROM bookmarks")
    suspend fun deleteAll()
}
