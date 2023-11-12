package com.example.organisator

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Erstelle eine veränderliche Liste
        val liste = mutableListOf("Äpfel", "Birnen", "Eier")
        liste.add("Wasser")

        // Erstelle einen ArrayAdapter
        val adapter = MyAdapter(this, liste)

        // Finde die ListView und setze den Adapter
        val listView = findViewById<ListView>(R.id.ListView)
        listView.adapter = adapter
    }

    inner class MyAdapter(context: Context, private val liste: List<String>) : ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, liste) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = super.getView(position, convertView, parent)
            val textView = view.findViewById<TextView>(android.R.id.text1)

            // Ändern Sie hier die Farbe
            textView.setTextColor(Color.RED)  // Setzen Sie hier die gewünschte Farbe ein

            // Ändern Sie hier die Schriftgröße
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)  // Setzen Sie hier die gewünschte Schriftgröße ein

            return view
        }
    }
}
