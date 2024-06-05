package com.example.chapter12assigment

import android.annotation.SuppressLint
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.chapter12assigment.databinding.ActivityContectManagerBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ContectManagerActivity : AppCompatActivity() {
    private lateinit var databaseReference: DatabaseReference
    private lateinit var dialog : Dialog
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contect_manager)

        dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_layout)
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bg_alert_box))

        val btnAdd =findViewById<Button>(R.id.btnAdd)
        val etEmail = findViewById<TextInputEditText>(R.id.etCMail)
        val etMobileNumber = findViewById<TextInputEditText>(R.id.etCMobileNumber)
        val etName = findViewById<TextInputEditText>(R.id.etCName)

        btnAdd.setOnClickListener {
            val address = etEmail.text.toString()
            val mobileNumber = etMobileNumber.text.toString()
            val name = etName.text.toString()

            val user = Users2(name,address,mobileNumber)
            databaseReference = FirebaseDatabase.getInstance().getReference("Users")
            databaseReference.child(mobileNumber).setValue(user).addOnSuccessListener {
                etName.text?.clear()
                etEmail.text?.clear()
                etMobileNumber.text?.clear()
//                Toast.makeText(this,"Contact Added Successfully..",Toast.LENGTH_SHORT).show()
                dialog.show()
            }.addOnSuccessListener {
                Toast.makeText(this,"Error..",Toast.LENGTH_SHORT).show()
            }
        }
    }
}