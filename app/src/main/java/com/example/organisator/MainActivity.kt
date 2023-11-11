package com.example.organisator

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Animation
        val floatingAnimation = AnimationUtils.loadAnimation(this, R.anim.floating_text)
        textView = findViewById(R.id.textView)
        textView.startAnimation(floatingAnimation)

        // Erstelle eine veränderliche Liste
        val liste = mutableListOf("Äpfel", "Birnen", "Eier")
        liste.add("Wasser")

        // Erstelle einen ArrayAdapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, liste)

        // Finde die ListView und setze den Adapter
        val listView = findViewById<ListView>(R.id.ListView)
        listView.adapter = adapter
    }
}
