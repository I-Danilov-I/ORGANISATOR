package com.example.organisator

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val floatingAnimation = AnimationUtils.loadAnimation(this, R.anim.floating_text)
        textView = findViewById(R.id.textView)
        textView.startAnimation(floatingAnimation)
    }
}
