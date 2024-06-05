package com.example.chapter9alertdialogue

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.chapter9alertdialogue.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Are You Sure?")
            builder1.setIcon(R.drawable.baseline_exit_to_app_24)
            builder1.setMessage("Do you want to close the app?")
            builder1.setPositiveButton("Yes",DialogInterface.OnClickListener { dialog, which ->
                // what action should be performed when Yes is clicked
                finish()
            })
            builder1.setNegativeButton("No",DialogInterface.OnClickListener { dialog, which ->

            })
            builder1.show()
        }
        binding.btn2.setOnClickListener {
            val options = arrayOf("Virat Kohli","Rohit Sharma","MS Dhoni","ABD","SKY","KL Rahul")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Choose your favourite Cricketer?")
            builder2.setSingleChoiceItems(options,0,DialogInterface.OnClickListener { dialog, which ->
                // what action should be performed when user click on any option
                Toast.makeText(this, "You clicked on ${options[which]}",Toast.LENGTH_SHORT).show()
            })
            builder2.setPositiveButton("Submit",DialogInterface.OnClickListener { dialog, which ->
                // what action should be performed when Submit is clicked
            })
            builder2.setNegativeButton("Decline",DialogInterface.OnClickListener { dialog, which ->

            })
            builder2.show()
        }
        binding.btn3.setOnClickListener {
            val options = arrayOf("Butter Paneer","Burger","Pizza","Tikki","Aalu paratha","Chola Gulcha")
            val builder3 = AlertDialog.Builder(this)
            builder3.setTitle("Select Food To Order")
            builder3.setMultiChoiceItems(options,null,DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                // what action should be performed when user click on any option
                Toast.makeText(this, "Select${options[which]}",Toast.LENGTH_SHORT).show()
            })
            builder3.setPositiveButton("Submit",DialogInterface.OnClickListener { dialog, which ->
                // what action should be performed when Submit is clicked

            })
            builder3.setNegativeButton("Decline",DialogInterface.OnClickListener { dialog, which ->

            })
            builder3.show()
        }
    }
}