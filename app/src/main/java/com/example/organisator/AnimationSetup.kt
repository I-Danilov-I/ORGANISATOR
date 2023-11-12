package com.example.organisator

import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AnimationSetup(private val activity: AppCompatActivity) {
    fun setupAnimation() {
        val textanimation = activity.findViewById<TextView>(R.id.textView)
        val animation = AnimationUtils.loadAnimation(activity, R.anim.floating_text)
        textanimation.startAnimation(animation)
    }
}
