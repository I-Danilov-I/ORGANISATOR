package com.example.organisator

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class ListDataManager(private val context: Context) {
    fun saveList(list: MutableList<String>) {
        val sharedPreferences = context.getSharedPreferences("com.example.organisator", Context.MODE_PRIVATE)
        sharedPreferences.edit().putString("list_data", Gson().toJson(list)).apply()
    }

    fun readList(): MutableList<String> {
        val sharedPreferences = context.getSharedPreferences("com.example.organisator", Context.MODE_PRIVATE)
        val savedList = sharedPreferences.getString("list_data", null)
        return if (savedList != null) {
            val type = object : TypeToken<MutableList<String>>() {}.type
            Gson().fromJson(savedList, type)
        } else {
            mutableListOf("Äpfel", "Birnen", "Eier")
        }
    }
}
