package com.example.chapter15recyclerview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class NewsDetailsActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)

        val heading = intent.getStringExtra("heading")
        val imageId = intent.getIntExtra("imageId",R.drawable.img1)
        val newsContent = intent.getStringExtra("newscontent")

        val headingTV = findViewById<TextView>(R.id.newHeading)
        val headingIV =  findViewById<ImageView>(R.id.newImage)
        val newsContentTV = findViewById<TextView>(R.id.newContect)

        headingTV.text = heading
        headingIV.setImageResource(imageId)
        newsContentTV.text = newsContent
    }
}