package com.example.chapter7viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.chapter7viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.btnDownload.setOnClickListener {
            Toast.makeText(this, "Download Successfully..",Toast.LENGTH_SHORT).show()
        }

        binding.btnUpload.setOnClickListener {
            Toast.makeText(this, "Uploading Successfully..",Toast.LENGTH_SHORT).show()
        }
    }
}