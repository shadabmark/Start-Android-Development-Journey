package com.example.chapter6passdatafromonescreentoother

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class OrderHerActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_her)

        val tvOrder1 = findViewById<TextView>(R.id.tvOrder1)
        val tvOrder2 = findViewById<TextView>(R.id.tvOrder2)
        val tvOrder3 = findViewById<TextView>(R.id.tvOrder3)
        val tvOrder4 = findViewById<TextView>(R.id.tvOrder4)
        val tvOrder5 = findViewById<TextView>(R.id.tvOrder5)

        val orderOfCustomer1=intent.getStringExtra(MainActivity.KEY1)
        val orderOfCustomer2=intent.getStringExtra(MainActivity.KEY2)
        val orderOfCustomer3=intent.getStringExtra(MainActivity.KEY3)
        val orderOfCustomer4=intent.getStringExtra(MainActivity.KEY4)
        val orderOfCustomer5=intent.getStringExtra(MainActivity.KEY5)


        tvOrder1.text= orderOfCustomer1.toString()
        tvOrder2.text= orderOfCustomer2.toString()
        tvOrder3.text= orderOfCustomer3.toString()
        tvOrder4.text= orderOfCustomer4.toString()
        tvOrder5.text= orderOfCustomer5.toString()

    }
}