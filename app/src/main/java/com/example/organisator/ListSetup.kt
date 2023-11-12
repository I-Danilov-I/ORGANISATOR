// Importieren Sie die benötigten Android- und Kotlin-Bibliotheken
package com.example.organisator

import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter

// Definieren Sie die ListSetup-Klasse
class ListSetup(private val activity: AppCompatActivity,
                private val liste: MutableList<String>,
                private val adapter: ArrayAdapter<String>,) {
    // Methode zum Einrichten der Liste
    fun setupList() {
        // Finden Sie die ListView und setzen Sie den Adapter
        val listView = activity.findViewById<ListView>(R.id.ListView)
        listView.adapter = adapter



        // Setzen Sie einen OnItemLongClickListener für die ListView
        listView.setOnItemLongClickListener { _, _, position, _ ->
            // Entfernen Sie den Eintrag an der angeklickten Position aus der Liste
            liste.removeAt(position)
            // Benachrichtigen Sie den Adapter, dass sich die Daten geändert haben
            adapter.notifyDataSetChanged()
            true
        }
    }
}
