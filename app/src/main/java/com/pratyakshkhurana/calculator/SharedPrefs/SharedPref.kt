package com.pratyakshkhurana.calculator.SharedPrefs

import android.content.Context

class SharedPref(context: Context) {

    private val inputTag = "input"
    private val outputTag = "output"
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

    fun getInput(): String = sharedPreferences.getString(inputTag, "0").toString()
    fun getOutput(): String = sharedPreferences.getString(outputTag, "0").toString()
}
