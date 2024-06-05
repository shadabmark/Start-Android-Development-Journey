package com.example.chapter12assigment

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SingUpActivity : AppCompatActivity() {
    lateinit var database : DatabaseReference
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up)

        val btnSinUp = findViewById<Button>(R.id.btnSinUp)
        val etName = findViewById<TextInputEditText>(R.id.etName)
        val etMail = findViewById<TextInputEditText>(R.id.etMail)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)
        val etNickName = findViewById<TextInputEditText>(R.id.etNickName)
        val tvGo = findViewById<TextView>(R.id.tvGo)

        btnSinUp.setOnClickListener {
           val name = etName.text.toString()
           val email = etMail.text.toString()
           val password = etPassword.text.toString()
           val nickName = etNickName.text.toString()

           val user = Users(name, email, password,nickName)
            database = FirebaseDatabase.getInstance().getReference("Users")
            database.child(nickName).setValue(user).addOnSuccessListener {
                etName.text?.clear()
                etMail.text?.clear()
                etPassword.text?.clear()
                etNickName.text?.clear()
                Toast.makeText(this, "User Registered Successfully..",Toast.LENGTH_SHORT).show()
            }.addOnSuccessListener {
                Toast.makeText(this, "Failed...",Toast.LENGTH_SHORT).show()
            }
        }
        tvGo.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}