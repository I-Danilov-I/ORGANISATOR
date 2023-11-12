// Importieren Sie die benötigten Android- und Kotlin-Bibliotheken
package com.example.organisator

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity

// Definieren Sie die MainActivity-Klasse, die von AppCompatActivity erbt
class MainActivity : AppCompatActivity() {

    // Deklaration der Liste und des Adapters auf Klassenebene, damit sie in mehreren Methoden verwendet werden können
    private lateinit var liste: MutableList<String>
    private lateinit var adapter: ArrayAdapter<String>

    // Die Methode onCreate wird aufgerufen, wenn die Aktivität erstellt wird
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialisierung der Liste und des Adapters
        liste = mutableListOf("Äpfel", "Birnen", "Eier")
        adapter = MyAdapter(this, liste)

        // Aufruf der Setup-Methoden
        AnimationSetup(this).setupAnimation()  // Einrichten der Animation
        ListSetup(this, liste, adapter).setupList()  // Einrichten der Liste
        ButtonSetup(this, liste, adapter).setupButtons()  // Einrichten der Buttons
    }
}
