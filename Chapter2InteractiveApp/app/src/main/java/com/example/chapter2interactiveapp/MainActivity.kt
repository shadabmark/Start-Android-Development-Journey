package com.example.chapter2interactiveapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDark = findViewById<Button>(R.id.btnDark)
        val btnLight = findViewById<Button>(R.id.btnLight)
        val layout = findViewById<LinearLayout>(R.id.Linearlayout)
        btnDark.setOnClickListener {
            layout.setBackgroundResource(R.color.black)
        }
        btnLight.setOnClickListener {
            layout.setBackgroundResource(R.color.white)
        }
    }
}