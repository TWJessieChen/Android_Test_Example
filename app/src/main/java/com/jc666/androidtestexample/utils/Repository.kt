package com.jc666.androidtestexample.utils

import android.content.Context
import com.jc666.androidtestexample.utils.SharedPreferenceManager

class Repository(val context: Context) {

    fun saveUserId(id: String) {
        val sharedPreferenceManager = SharedPreferenceManager(context)
        sharedPreferenceManager.saveString(id)
    }
}