package com.gc.ktx

import android.content.SharedPreferences

fun SharedPreferences.put(key: String, value: Any) {
    val editor = edit()
    when (value) {
        is String -> editor.putString(key, value)
        is Int -> editor.putInt(key, value)
        is Boolean -> editor.putBoolean(key, value)
        is Long -> editor.putLong(key, value)
        is Float -> editor.putFloat(key, value)
    }
    editor.apply()
}

fun SharedPreferences.get(key: String, defaultValue: Any): Any? {
    return when (defaultValue) {
        is String -> getString(key, defaultValue)
        is Int -> getInt(key, defaultValue)
        is Boolean -> getBoolean(key, defaultValue)
        is Long -> getLong(key, defaultValue)
        is Float -> getFloat(key, defaultValue)
        else -> null
    }
}