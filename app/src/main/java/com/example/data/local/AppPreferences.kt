package com.example.data.local

import android.content.Context
import android.content.SharedPreferences

class AppPreferences(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("ekonomiku_prefs", Context.MODE_PRIVATE)

    var darkMode: String
        get() = prefs.getString(KEY_DARK_MODE, "system") ?: "system"
        set(value) = prefs.edit().putString(KEY_DARK_MODE, value).apply()

    var textScale: Float
        get() = prefs.getFloat(KEY_TEXT_SCALE, 1.0f)
        set(value) = prefs.edit().putFloat(KEY_TEXT_SCALE, value).apply()

    var reminderEnabled: Boolean
        get() = prefs.getBoolean(KEY_REMINDER_ENABLED, true)
        set(value) = prefs.edit().putBoolean(KEY_REMINDER_ENABLED, value).apply()

    var reminderHour: String
        get() = prefs.getString(KEY_REMINDER_HOUR, "19:00") ?: "19:00"
        set(value) = prefs.edit().putString(KEY_REMINDER_HOUR, value).apply()

    fun isSubbabRead(subbabId: String): Boolean {
        val set = prefs.getStringSet(KEY_READ_SUBBABS, emptySet()) ?: emptySet()
        return set.contains(subbabId)
    }

    fun markSubbabRead(subbabId: String): Boolean {
        val set = (prefs.getStringSet(KEY_READ_SUBBABS, emptySet()) ?: emptySet()).toMutableSet()
        val isFirstTime = set.add(subbabId)
        if (isFirstTime) {
            prefs.edit().putStringSet(KEY_READ_SUBBABS, set).apply()
        }
        return isFirstTime
    }

    fun getReadSubbabsCount(): Int {
        return prefs.getStringSet(KEY_READ_SUBBABS, emptySet())?.size ?: 0
    }

    fun clearAll() {
        prefs.edit().clear().apply()
    }

    companion object {
        private const val KEY_DARK_MODE = "key_dark_mode"
        private const val KEY_TEXT_SCALE = "key_text_scale"
        private const val KEY_REMINDER_ENABLED = "key_reminder_enabled"
        private const val KEY_REMINDER_HOUR = "key_reminder_hour"
        private const val KEY_READ_SUBBABS = "key_read_subbabs"
    }
}
