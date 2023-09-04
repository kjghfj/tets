package com.ulimit.test

import android.content.Context
import android.content.SharedPreferences

class Preferences (context: Context) {
    val SHARED_PREF_NAME = "shared_pref"
    private var mPref: SharedPreferences =
        context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    fun save(key: String, value: String?) {
        mPref.edit().putString(key, value).apply()
    }
    fun getString(key: String): String? {
        return mPref.getString(key, "")
    }
}