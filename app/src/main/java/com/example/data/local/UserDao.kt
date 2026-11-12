package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM users WHERE id = 1 LIMIT 1")
    fun getUser(): Flow<User?>

    @Query("SELECT * FROM users WHERE id = 1 LIMIT 1")
    suspend fun getUserSync(): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(user: User)

    @Query("UPDATE users SET xp = :xp, level = :level, lencanaTerbuka = :lencana WHERE id = 1")
    suspend fun updateXpAndLevel(xp: Int, level: Int, lencana: String)

    @Query("DELETE FROM users")
    suspend fun deleteAll()
}
