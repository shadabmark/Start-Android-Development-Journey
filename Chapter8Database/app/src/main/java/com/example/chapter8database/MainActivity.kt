package com.example.chapter8database

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.chapter8database.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var database : DatabaseReference
private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSingUp.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etMail.text.toString()
            val uniqueId = binding.etUniqueId.text.toString()
            val password = binding.etPassword.text.toString()

            val user = User(name,email,password,uniqueId)
            database = FirebaseDatabase.getInstance().getReference("Users")

            database.child(uniqueId).setValue(user).addOnSuccessListener {
                binding.etName.text?.clear()
                binding.etMail.text?.clear()
                binding.etPassword.text?.clear()
                binding.etUniqueId.text?.clear()
                Toast.makeText(this, "User register successfully",Toast.LENGTH_SHORT).show()
            }.addOnSuccessListener {
                Toast.makeText(this, "Error",Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnNext.setOnClickListener{
            intent= Intent(this, SingInActivity::class.java)
            startActivity(intent)
        }

    }
}