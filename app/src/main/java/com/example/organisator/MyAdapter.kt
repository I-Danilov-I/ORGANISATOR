// Importieren Sie die benötigten Android- und Kotlin-Bibliotheken
package com.example.organisator

import android.content.Context
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat

// Definieren Sie die MyAdapter-Klasse, die von ArrayAdapter erbt
class MyAdapter(context: Context, liste: List<String>) : ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, liste) {

    // Überschreiben Sie die getView-Methode, um die Darstellung jedes Elements in der Liste anzupassen
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Rufen Sie die ursprüngliche getView-Methode auf, um das Standard-ListView-Element zu erhalten
        val view = super.getView(position, convertView, parent)
        // Finden Sie das TextView-Element im ListView-Element
        val textView = view.findViewById<TextView>(android.R.id.text1)

        // Ändern Sie die Farbe des Texts
        textView.setTextColor(ContextCompat.getColor(context, R.color.colorTextListe))

        // Ändern Sie die Schriftgröße des Texts
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)

        // Geben Sie das modifizierte ListView-Element zurück
        return view
    }
}
