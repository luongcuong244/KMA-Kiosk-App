package com.example.kmakioskapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen)

        val red = (0..255).random()
        val green = (0..255).random()
        val blue = (0..255).random()
        val color = Color.rgb(red, green, blue)
        findViewById<LinearLayout>(R.id.root).setBackgroundColor(color)

        val screenIndex = intent.getIntExtra("screenIndex", 1)

        findViewById<TextView>(R.id.tvTitle).text = "Screen $screenIndex"

        findViewById<Button>(R.id.btnPrevious).setOnClickListener {
            finish()
        }
        findViewById<Button>(R.id.btnNext).setOnClickListener {
            val nextScreenIndex = screenIndex + 1
            val intent = Intent(this, ScreenActivity::class.java)
            intent.putExtra("screenIndex", nextScreenIndex)
            startActivity(intent)
        }
    }
}