package com.pratyakshkhurana.calculator.SharedPrefs

import android.content.Context

class SharedPref(context: Context) {

    private val inputTag = "input"
    private val outputTag = "output"
    private val nightModeTag = "nightModeTag"
    private val sharedPreferences = context.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()

    fun saveInput(s: String) {
        editor.apply {
            putString(inputTag, s)
            apply()
        }
    }

    fun saveOutput(s: String) {
        editor.apply {
            putString(outputTag, s)
            apply()
        }
    }

    fun saveIsNightModeEnabled(b: Boolean) {
        editor.apply {
            putBoolean(nightModeTag, b)
            apply()
        }
    }

    fun getIsNightModeEnabled(): Boolean = sharedPreferences.getBoolean(nightModeTag, false)

    fun getInput(): String = sharedPreferences.getString(inputTag, "").toString()
    fun getOutput(): String = sharedPreferences.getString(outputTag, "").toString()
}
