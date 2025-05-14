package com.android.pransh.robokalamtask

import android.content.Context

class SessionManager(context: Context) {
    private val prefs = context.getSharedPreferences("UserSession", Context.MODE_PRIVATE)

    fun saveUser(name: String, email: String) {
        prefs.edit().apply {
            putString("name", name)
            putString("email", email)
            putBoolean("isLoggedIn", true)
            apply()
        }
    }

    fun getUserName(): String = prefs.getString("name", "") ?: ""
    fun isLoggedIn(): Boolean = prefs.getBoolean("isLoggedIn", false)
    fun logout() = prefs.edit().clear().apply()
}