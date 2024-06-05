package com.example.chapter6passdatafromonescreentoother

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    companion object{
        const val KEY1 = "com.example.chapter6passdatafromonescreentoothe.MainActivity.KEY1"
        const val KEY2 = "com.example.chapter6passdatafromonescreentoothe.MainActivity.KEY2"
        const val KEY3 = "com.example.chapter6passdatafromonescreentoothe.MainActivity.KEY3"
        const val KEY4 = "com.example.chapter6passdatafromonescreentoothe.MainActivity.KEY4"
        const val KEY5 = "com.example.chapter6passdatafromonescreentoothe.MainActivity.KEY5"
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnOrder = findViewById<Button>(R.id.btnOrder)
        val et1 = findViewById<EditText>(R.id.et1)
        val et2 = findViewById<EditText>(R.id.et2)
        val et3 = findViewById<EditText>(R.id.et3)
        val et4 = findViewById<EditText>(R.id.et4)
        val et5 = findViewById<EditText>(R.id.et5)

        btnOrder.setOnClickListener {
            val order1= et1.text.toString()
            val order2= et2.text.toString()
            val order3= et3.text.toString()
            val order4= et4.text.toString()
            val order5= et5.text.toString()

            intent= Intent(this, OrderHerActivity::class.java)
            intent.putExtra(KEY1, order1)
            intent.putExtra(KEY2, order2)
            intent.putExtra(KEY3, order3)
            intent.putExtra(KEY4, order4)
            intent.putExtra(KEY5, order5)
            startActivity(intent)
        }
    }
}