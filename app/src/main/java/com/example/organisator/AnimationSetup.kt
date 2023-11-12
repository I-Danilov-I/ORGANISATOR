// Importieren Sie die benötigten Android- und Kotlin-Bibliotheken
package com.example.organisator

import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// Definieren Sie die AnimationSetup-Klasse
class AnimationSetup(private val activity: AppCompatActivity) {
    // Methode zum Einrichten der Animation
    fun setupAnimation() {
        // Finden Sie das TextView-Element
        val textanimation = activity.findViewById<TextView>(R.id.textView)
        // Laden Sie die Animation
        val animation = AnimationUtils.loadAnimation(activity, R.anim.floating_text)
        // Starten Sie die Animation auf dem TextView-Element
        textanimation.startAnimation(animation)
    }
}
