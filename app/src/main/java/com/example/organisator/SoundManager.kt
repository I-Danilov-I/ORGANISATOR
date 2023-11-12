package com.example.organisator

import android.content.Context
import android.media.MediaPlayer

class SoundManager(private val context: Context) {
    fun playSound() {
        val mediaPlayer = MediaPlayer.create(context, R.raw.sound_file_add)
        mediaPlayer.start()
    }
}
