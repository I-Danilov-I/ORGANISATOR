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
    private lateinit var listDataManager: ListDataManager
    private lateinit var soundManager: SoundManager  // Deklarieren Sie soundManager hier

    // In Ihrer MainActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listDataManager = ListDataManager(this)
        soundManager = SoundManager(this)  // Erstellen Sie eine Instanz von SoundManager

        liste = mutableListOf("Äpfel", "Birnen", "Eier")
        liste = listDataManager.readList()

        adapter = MyAdapter(this, liste)

        AnimationSetup(this).setupAnimation()
        ListSetup(this, liste, adapter).setupList()
        ButtonSetup(
            this,
            liste,
            adapter,
            soundManager
        ).setupButtons()  // Übergeben Sie soundManager hier
    }

    override fun onPause() {
        super.onPause()
        listDataManager.saveList(liste)
    }
}
