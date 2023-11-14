package com.example.organisator

import android.content.Context
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MyAdapter(context: Context, liste: List<String>) : ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, liste) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getView(position, convertView, parent)
        val textView = view.findViewById<TextView>(android.R.id.text1)

        // Ändern Sie die Farbe und die Schriftgröße des Texts
        textView.setTextColor(ContextCompat.getColor(context, R.color.colorTextListe))
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24f)

        return view
    }
}

class ListSetup(private val activity: AppCompatActivity,
                private val liste: MutableList<String>,
                private val adapter: ArrayAdapter<String>,
                private val soundManager: SoundManager) {
    // Methode zum Einrichten der Liste
    fun setupList() {
        // Finden Sie die ListView und setzen Sie den Adapter
        val listView = activity.findViewById<ListView>(R.id.ListView)
        listView.adapter = adapter

        // Setzen Sie einen OnItemLongClickListener für die ListView
        listView.setOnItemLongClickListener { _, _, position, _ ->
            soundManager.playSound(R.raw.sound_file_delete)
            // Entfernen Sie den Eintrag an der angeklickten Position aus der Liste
            liste.removeAt(position)
            // Benachrichtigen Sie den Adapter, dass sich die Daten geändert haben
            adapter.notifyDataSetChanged()
            true
        }
    }
}

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
