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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ersetzen Sie dies durch die ID Ihres ImageView-Elements
        val textanimation = findViewById<TextView>(R.id.textView)
        // Laden Sie die Animation
        val animation = AnimationUtils.loadAnimation(this, R.anim.floating_text)

        // Starten Sie die Animation
        textanimation.startAnimation(animation)

        // Erstelle eine veränderliche Liste
        val liste = mutableListOf("Äpfel", "Birnen", "Eier")

        // Erstelle einen ArrayAdapter
        val adapter = MyAdapter(this, liste)

        // Finde die ListView und setze den Adapter
        val listView = findViewById<ListView>(R.id.ListView)
        listView.adapter = adapter

        // Set Button begeung
        val settingsButton = findViewById<ImageButton>(R.id.set_button)
        val setbuttonanimation = AnimationUtils.loadAnimation(this, R.anim.set_button)
        settingsButton.startAnimation(setbuttonanimation)


        // Hinzufüge Button
        val addButton = findViewById<ImageButton>(R.id.addButton)
        addButton.setOnClickListener {
            // Fügen Sie hier den Eintrag zur Liste hinzu
            liste.add("Neuer Eintrag")
            // Benachrichtigen Sie den Adapter, dass sich die Daten geändert haben
            adapter.notifyDataSetChanged()
        }

        // Sobal das Textfeld zur Eingabe angeklickt wird, bereits stehen TExt löschen
        val textEingabe = findViewById<EditText>(R.id.TextEingabe)
        textEingabe.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                // Löschen Sie den Text, wenn das EditText-Element den Fokus erhält
                (v as EditText).text.clear()
            }
        }


    }

    inner class MyAdapter(context: Context, liste: List<String>) : ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, liste) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = super.getView(position, convertView, parent)
            val textView = view.findViewById<TextView>(android.R.id.text1)

            // Ändern Sie hier die Farbe
            textView.setTextColor(ContextCompat.getColor(context, R.color.colorTextListe))

            // Ändern Sie hier die Schriftgröße
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)  // Setzen Sie hier die gewünschte Schriftgröße ein

            return view
        }
    }
}
