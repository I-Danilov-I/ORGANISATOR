package com.example.organisator

import android.content.Context
import android.media.MediaPlayer

class SoundManager(private val context: Context) {
    fun playSound(soundfile: Int) {
        val mediaPlayer = MediaPlayer.create(context, soundfile)
        mediaPlayer.start()
    }
}
