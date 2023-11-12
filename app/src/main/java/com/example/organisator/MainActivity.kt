package com.example.organisator

import MyAdapter
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Deklaration der Liste und des Adapters auf Klassenebene
    private lateinit var liste: MutableList<String>
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialisierung der Liste und des Adapters
        liste = mutableListOf("Äpfel", "Birnen", "Eier")
        adapter = MyAdapter(this, liste)

        // Aufruf der Setup-Methoden
        AnimationSetup(this).setupAnimation()
        ListSetup(this, liste, adapter).setupList()
        ButtonSetup(this, liste, adapter).setupButtons()
    }

}
