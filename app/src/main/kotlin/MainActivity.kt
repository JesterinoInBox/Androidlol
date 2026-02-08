package com.example.lovevera

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var heartsContainer: FrameLayout
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        heartsContainer = findViewById(R.id.heartsContainer)
        val button = findViewById<Button>(R.id.loveButton)

        startFallingHearts()

        button.setOnClickListener {
            repeat(10) {
                addHeart()
            }
        }
    }

    private fun startFallingHearts() {
        handler.post(object : Runnable {
            override fun run() {
                addHeart()
                handler.postDelayed(this, 400)
            }
        })
    }

    private fun addHeart() {
        val heart = layoutInflater.inflate(R.layout.heart_view, heartsContainer, false)
        heartsContainer.addView(heart)
    }
}
