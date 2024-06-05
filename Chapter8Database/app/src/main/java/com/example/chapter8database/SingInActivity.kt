package com.example.chapter8database

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.chapter8database.databinding.ActivitySingInBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SingInActivity : AppCompatActivity() {
    private lateinit var databaseReference: DatabaseReference
    private lateinit var binding: ActivitySingInBinding

    companion object{
        const val KEY1 = "com.example.chapter8database.name"
        const val KEY2 = "com.example.chapter8database.email"
        const val KEY3 = "com.example.chapter8database.password"
        const val KEY4 = "com.example.chapter8database.uniqueId"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingInBinding.inflate(layoutInflater)
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
               val name = it.child("name").value
                val email = it.child("email").value
                val password = it.child("password").value
                val uniqueId = it.child("uniqueId").value

                val intentShowInfo = Intent(this, ShowYourInfo::class.java)
                intentShowInfo.putExtra(KEY1,name.toString())
                intentShowInfo.putExtra(KEY2,email.toString())
                intentShowInfo.putExtra(KEY3,password.toString())
                intentShowInfo.putExtra(KEY4,uniqueId.toString())
                startActivity(intentShowInfo)
            }else{
                Toast.makeText(this, "User not exist",Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this, "error in DB",Toast.LENGTH_SHORT).show()
        }
    }
}