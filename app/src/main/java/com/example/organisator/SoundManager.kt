package com.example.organisator

import android.content.Context
import android.media.MediaPlayer

class SoundManager(private val context: Context) {
    private var isOn = true

    fun loadAudioStatus() {
        val sharedPreferences = context.getSharedPreferences("MyApp", Context.MODE_PRIVATE)
        isOn = sharedPreferences.getBoolean("AudioStatus", true)
    }

    fun playSound(soundfile: Int) {
        if (isOn) {
            val mediaPlayer = MediaPlayer.create(context, soundfile)
            mediaPlayer.start()
        }
    }

    fun turnOn() {
        isOn = true
    }

    fun turnOff() {
        isOn = false
    }


}
