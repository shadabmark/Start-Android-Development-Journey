package com.example.chapter12assigment

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.chapter12assigment.databinding.ActivitySignInBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignInActivity : AppCompatActivity() {
    private lateinit var databaseReference: DatabaseReference
    private lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignIn.setOnClickListener {
            val nickName = binding.etNameEditText.text.toString()
            if (nickName.isNotEmpty()){
                readData(nickName)
            }else{
                Toast.makeText(this, "please enter UniqueId",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readData(nickName: String) {
        databaseReference= FirebaseDatabase.getInstance().getReference("Users")
        databaseReference.child(nickName).get().addOnSuccessListener {
            if (it.exists()){
                intent = Intent(this,ContectManagerActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "User not exist",Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this, "error in DB",Toast.LENGTH_SHORT).show()
        }
    }
}