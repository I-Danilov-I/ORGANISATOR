package com.example.organisator

import android.content.Context
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {

    // Deklaration der Liste und des Adapters auf Klassenebene, damit sie in mehreren Methoden verwendet werden können
    private lateinit var liste: MutableList<String>
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Aufruf der Setup-Methoden
        setupAnimation()
        setupList()
        setupButtons()
    }

    // Methode zum Einrichten der Animation
    private fun setupAnimation() {
        // Finden Sie das TextView-Element und laden Sie die Animation
        val textanimation = findViewById<TextView>(R.id.textView)
        val animation = AnimationUtils.loadAnimation(this, R.anim.floating_text)

        // Starten Sie die Animation
        textanimation.startAnimation(animation)
    }

    // Methode zum Einrichten der Liste
    private fun setupList() {
        // Erstellen Sie die Liste und den Adapter
        liste = mutableListOf("Äpfel", "Birnen", "Eier")
        adapter = MyAdapter(this, liste)

        // Finden Sie die ListView und setzen Sie den Adapter
        val listView = findViewById<ListView>(R.id.ListView)
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

    // Methode zum Einrichten der Buttons
    private fun setupButtons() {
        // Finden Sie die Buttons und setzen Sie die OnClickListener
        val settingsButton = findViewById<ImageButton>(R.id.set_button)
        val setbuttonanimation = AnimationUtils.loadAnimation(this, R.anim.set_button)
        settingsButton.startAnimation(setbuttonanimation)

        val addButton = findViewById<ImageButton>(R.id.addButton)
        addButton.setOnClickListener {
            val textEingabe = findViewById<EditText>(R.id.TextEingabe)
            val eingabeText = textEingabe.text.toString()
            if (eingabeText.isNotEmpty()) {
                liste.add(eingabeText)
                textEingabe.text.clear()
                adapter.notifyDataSetChanged()
            }
        }

        val textEingabe = findViewById<EditText>(R.id.TextEingabe)
        textEingabe.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                (v as EditText).text.clear()
            }
        }
    }

    // Innere Klasse für den benutzerdefinierten ArrayAdapter
    inner class MyAdapter(context: Context, liste: List<String>) : ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, liste) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = super.getView(position, convertView, parent)
            val textView = view.findViewById<TextView>(android.R.id.text1)

            // Ändern Sie die Farbe und die Schriftgröße des Texts
            textView.setTextColor(ContextCompat.getColor(context, R.color.colorTextListe))
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)

            return view
        }
    }
}

