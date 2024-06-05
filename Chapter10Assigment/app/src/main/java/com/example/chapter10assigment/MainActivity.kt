package com.example.chapter10assigment

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.chapter10assigment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn1.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            val options = arrayOf("21 Jun", "28 Sep", "21 Fab", "22 Oct")
            builder1.setTitle("Quiestion1:  When is International Mother Language Day celebrated?")
            builder1.setSingleChoiceItems(options,0, DialogInterface.OnClickListener { dialog, which ->
                // what should be action click any option
            })
            builder1.setPositiveButton("Submit", DialogInterface.OnClickListener { dialog, which ->
                // what should be action click Submit
            })
            builder1.setNegativeButton("Decline", DialogInterface.OnClickListener { dialog, which ->

            })
            builder1.show()
        }
        binding.btn2.setOnClickListener {
            val builder2 = AlertDialog.Builder(this)
            val options = arrayOf(" Dr. B. R. Ambedkar", "Narendra Modi", "Gandhi Ji","Jawaharlal Nehru")
            builder2.setTitle("Quiestion2:  Who was the first Prime Minister of India?")
            builder2.setSingleChoiceItems(options,0, DialogInterface.OnClickListener { dialog, which ->
                // what should be action click any option
            })
            builder2.setPositiveButton("Submit", DialogInterface.OnClickListener { dialog, which ->
                // what should be action click Submit
            })
            builder2.setNegativeButton("Decline", DialogInterface.OnClickListener { dialog, which ->

            })
            builder2.show()
        }
        binding.btn3.setOnClickListener {
            val builder2 = AlertDialog.Builder(this)
            val options = arrayOf("Kolkata"," Gujarat","Maharashtra","Rajasthan")
            builder2.setTitle("Quiestion2:  Victoria Memorial is situated in which city of India??")
            builder2.setSingleChoiceItems(options,0, DialogInterface.OnClickListener { dialog, which ->
                // what should be action click any option
            })
            builder2.setPositiveButton("Submit", DialogInterface.OnClickListener { dialog, which ->
                // what should be action click Submit
            })
            builder2.setNegativeButton("Decline", DialogInterface.OnClickListener { dialog, which ->

            })
            builder2.show()
        }
        binding.btn4.setOnClickListener {
            val builder2 = AlertDialog.Builder(this)
            val options = arrayOf("Earth","Mars", "Mercury","Saturn")
            builder2.setTitle("Quiestion2:   Which planet is closest to the Sun?")
            builder2.setSingleChoiceItems(options,0, DialogInterface.OnClickListener { dialog, which ->
                // what should be action click any option
            })
            builder2.setPositiveButton("Submit", DialogInterface.OnClickListener { dialog, which ->
                // what should be action click Submit
            })
            builder2.setNegativeButton("Decline", DialogInterface.OnClickListener { dialog, which ->

            })
            builder2.show()
        }
        binding.btn5.setOnClickListener {
            val builder2 = AlertDialog.Builder(this)
            val options = arrayOf(" Dr. B. R. Ambedkar", "Nehru","Gandhi Ji", "Abhimanyu")
            builder2.setTitle("Quiestion2:   Name the Father of the Indian Constitution?")
            builder2.setSingleChoiceItems(options,0, DialogInterface.OnClickListener { dialog, which ->
                // what should be action click any option
            })
            builder2.setPositiveButton("Submit", DialogInterface.OnClickListener { dialog, which ->
                // what should be action click Submit
            })
            builder2.setNegativeButton("Decline", DialogInterface.OnClickListener { dialog, which ->

            })
            builder2.show()
        }
        binding.btnExist.setOnClickListener {
            val builder6 = AlertDialog.Builder(this)
            builder6.setTitle("Are You Sure?")
            builder6.setMessage("Do you want to close the app?")
            builder6.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                finish()
            })
            builder6.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->  })
            builder6.show()
        }
    }
}