package com.jc666.androidtestexample.utils

import android.content.Context

interface ISharePreferenceManager {
    val context: Context
    fun saveString(value: String)
    fun saveString(key: String, value: String)
    fun getString(key: String): String
}