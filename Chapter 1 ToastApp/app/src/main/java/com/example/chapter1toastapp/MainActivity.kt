package com.example.chapter1toastapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonDownload = findViewById<Button>(R.id.btnDownload)
        val buttonUpload = findViewById<Button>(R.id.btnUpload)

        buttonDownload.setOnClickListener{
            Toast.makeText(applicationContext, "Download", Toast.LENGTH_SHORT).show()
        }
        buttonUpload.setOnClickListener {
            Toast.makeText(applicationContext, "Upload", Toast.LENGTH_SHORT).show()

        }
    }
}