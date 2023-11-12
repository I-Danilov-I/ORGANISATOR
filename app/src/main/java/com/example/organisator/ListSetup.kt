package com.example.organisator

import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter


class ListSetup(private val activity: AppCompatActivity, private val liste: MutableList<String>, private val adapter: ArrayAdapter<String>) {
    fun setupList() {
        val listView = activity.findViewById<ListView>(R.id.ListView)
        listView.adapter = adapter
        listView.setOnItemLongClickListener { _, _, position, _ ->
            liste.removeAt(position)
            adapter.notifyDataSetChanged()
            true
        }
    }
}
