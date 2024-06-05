package com.example.chapter12assigment

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.chapter12assigment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            intent = Intent(this, SingUpActivity::class.java)
            startActivity(intent)
        }
        binding.button2.setOnClickListener {
            intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}