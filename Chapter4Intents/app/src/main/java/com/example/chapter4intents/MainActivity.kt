package com.example.chapter4intents

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNext = findViewById<Button>(R.id.btnNextScreen)
        val btnWeb = findViewById<Button>(R.id.btnGoWeb)
        val btnCamera = findViewById<Button>(R.id.btnGoCamera)

        btnNext.setOnClickListener {
            // Explicit Intent_ Same app go to next screen
           intent= Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        btnWeb.setOnClickListener {
            // Implicit Intents − It going to connect with out side application such as call, mail, phone,see any website ..etc.
        val intent= Intent(Intent.ACTION_VIEW)
            intent.data= Uri.parse("https://kotlinlang.org/docs/kotlin-tour-welcome.html")
            startActivity(intent)
        }

        btnCamera.setOnClickListener {
            val intent= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }
    }
}