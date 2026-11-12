package com.example.notification

import android.content.Context
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.Calendar
import java.util.concurrent.TimeUnit

object ReminderScheduler {
    private const val WORK_NAME = "ekonomiku_daily_reminder_work"

    fun scheduleDailyReminder(context: Context, hourMinute: String) {
        val parts = hourMinute.split(":")
        val targetHour = parts.getOrNull(0)?.toIntOrNull() ?: 19
        val targetMinute = parts.getOrNull(1)?.toIntOrNull() ?: 0

        val calendar = Calendar.getInstance()
        val currentHour = calendar.get(Calendar.HOUR_OF_DAY)
        val currentMinute = calendar.get(Calendar.MINUTE)

        var delayMinutes = (targetHour * 60 + targetMinute) - (currentHour * 60 + currentMinute)
        if (delayMinutes <= 0) {
            delayMinutes += 24 * 60 // Schedule for next day
        }

        val workRequest = PeriodicWorkRequestBuilder<DailyReminderWorker>(24, TimeUnit.HOURS)
            .setInitialDelay(delayMinutes.toLong(), TimeUnit.MINUTES)
            .build()

        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            WORK_NAME,
            ExistingPeriodicWorkPolicy.UPDATE,
            workRequest
        )
    }

    fun cancelReminder(context: Context) {
        WorkManager.getInstance(context).cancelUniqueWork(WORK_NAME)
    }
}
