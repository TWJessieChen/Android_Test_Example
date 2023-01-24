package com.jc666.androidtestexample.utils

import android.content.Context

class RepositoryInterface(val sharedPreferenceManager: ISharePreferenceManager) {

    fun saveUserId(id: String) {
        sharedPreferenceManager.saveString("USER_ID", id)
    }
}