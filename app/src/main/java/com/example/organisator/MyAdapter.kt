package com.example.organisator

import android.content.Context
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat


// Innere Klasse für den benutzerdefinierten ArrayAdapter
class MyAdapter(context: Context, liste: List<String>) : ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, liste) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getView(position, convertView, parent)
        val textView = view.findViewById<TextView>(android.R.id.text1)

        // Ändern Sie die Farbe und die Schriftgröße des Texts
        textView.setTextColor(ContextCompat.getColor(context, R.color.colorTextListe))
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)

        return view
    }
}
