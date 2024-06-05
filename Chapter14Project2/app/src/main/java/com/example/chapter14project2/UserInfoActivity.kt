package com.example.chapter14project2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class UserInfoActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val image = intent.getIntExtra("image", R.drawable.pic1)

        val tvName = findViewById<TextView>(R.id.Name)
        val tvPhone = findViewById<TextView>(R.id.Phone)
        val tvImage = findViewById<ImageView>(R.id.profile_image)

        tvName.text = name
        tvPhone.text = phone
        tvImage.setImageResource(image)
    }
}