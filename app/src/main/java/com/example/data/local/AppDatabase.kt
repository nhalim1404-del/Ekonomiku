package com.example.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.model.Bookmark
import com.example.data.model.HasilLatihan
import com.example.data.model.LkpdSubmission
import com.example.data.model.User

@Database(
    entities = [
        User::class,
        HasilLatihan::class,
        Bookmark::class,
        LkpdSubmission::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun hasilLatihanDao(): HasilLatihanDao
    abstract fun bookmarkDao(): BookmarkDao
    abstract fun lkpdSubmissionDao(): LkpdSubmissionDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "ekonomiku_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
