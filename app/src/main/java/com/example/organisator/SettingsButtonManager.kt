// SettingsButtonManager.kt
package com.example.organisator

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageButton
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity

class SettingsButtonManager(private val activity: AppCompatActivity, private val soundManager: SoundManager) {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    fun setupSettingsButton() {
        val setbuttonanimation = AnimationUtils.loadAnimation(activity, R.anim.set_button)

        // Finden Sie den settingsButton und setzen Sie einen OnClickListener
        val settingsButton = activity.findViewById<ImageButton>(R.id.set_button)
        settingsButton.setOnClickListener {
            // Erstellen Sie einen neuen Dialog
            val dialog = Dialog(activity)
            // Setzen Sie das Layout für den Dialog
            dialog.setContentView(R.layout.dialog_settings)

            // Finden Sie den audioSwitch im Dialog und setzen Sie einen OnCheckedChangeListener
            val audioSwitch = dialog.findViewById<Switch>(R.id.dialog_switch_audio_id)
            audioSwitch.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    // Audio einschalten
                    soundManager.turnOn()
                } else {
                    // Audio ausschalten
                    soundManager.turnOff()
                }
                // Speichern Sie den Zustand des Audios in den Einstellungen
                val sharedPreferences = activity.getSharedPreferences("MyApp", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putBoolean("AudioStatus", isChecked)
                editor.apply()
            }
            // Setzen Sie den Zustand des Schalters basierend auf dem gespeicherten Zustand in den Einstellungen
            val sharedPreferences = activity.getSharedPreferences("MyApp", Context.MODE_PRIVATE)
            val audioStatus = sharedPreferences.getBoolean("AudioStatus", true)
            audioSwitch.isChecked = audioStatus

            // Finden Sie den closeButton im Dialog und setzen Sie einen OnClickListener
            val closeButton = dialog.findViewById<Button>(R.id.dialog_button_close_id)
            closeButton.setOnClickListener {
                dialog.dismiss()
            }

            // Zeigen Sie den Dialog an
            dialog.show()
        }

        // Animation von Set Button starten
        settingsButton.startAnimation(setbuttonanimation)
    }
}
