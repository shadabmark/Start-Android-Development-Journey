package com.example.chapter8database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapter8database.databinding.ActivityShowYourInfoBinding

class ShowYourInfo : AppCompatActivity() {
    private lateinit var binding: ActivityShowYourInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowYourInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(SingInActivity.KEY1)
        val email = intent.getStringExtra(SingInActivity.KEY2)
        val password = intent.getStringExtra(SingInActivity.KEY3)
        val uniqueId = intent.getStringExtra(SingInActivity.KEY4)

        binding.tvWelcome.text = "Welcome: $name"
        binding.tvMail.text = "Email: $email"
        binding.tvPassword.text = "Password: $password"
        binding.tvID.text = "UniqueId: $uniqueId"
    }
}