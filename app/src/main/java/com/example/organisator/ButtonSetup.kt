package com.example.organisator

import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter


class ButtonSetup(private val activity: AppCompatActivity, private val liste: MutableList<String>, private val adapter: ArrayAdapter<String>) {
    fun setupButtons() {
        val settingsButton = activity.findViewById<ImageButton>(R.id.set_button)
        val setbuttonanimation = AnimationUtils.loadAnimation(activity, R.anim.set_button)
        settingsButton.startAnimation(setbuttonanimation)

        val addButton = activity.findViewById<ImageButton>(R.id.addButton)
        addButton.setOnClickListener {
            val textEingabe = activity.findViewById<EditText>(R.id.TextEingabe)
            val eingabeText = textEingabe.text.toString()
            if (eingabeText.isNotEmpty()) {
                liste.add(eingabeText)
                textEingabe.text.clear()
                adapter.notifyDataSetChanged()
            }
        }

        val textEingabe = activity.findViewById<EditText>(R.id.TextEingabe)
        textEingabe.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                (v as EditText).text.clear()
            }
        }
    }
}
