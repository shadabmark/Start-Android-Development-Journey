package com.example.chapter18fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.chapter18fragments.databinding.ActivityMainBinding
import com.example.chapter18fragments.ui.login.LoginFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFrameWithFragments(Home())
        // by default, home fragment should be visible to the user

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.item1 -> replaceFrameWithFragments(Home())
                R.id.item2 -> replaceFrameWithFragments(Search())
                R.id.item3 -> replaceFrameWithFragments(Profile())
                else->{

                }
            }
            true
        }

        binding.btnClock.setOnClickListener {

            replaceFrameWithFragments(Clock_Fragment())
        }

        binding.btnExam.setOnClickListener {

            replaceFrameWithFragments(Exam_Fragment())
        }

        binding.btnValidate.setOnClickListener {

            replaceFrameWithFragments(LoginFragment())
        }
    }

    private fun replaceFrameWithFragments(frag: Fragment) {

        val fragManager = supportFragmentManager
        val fragTransaction = fragManager.beginTransaction()
        fragTransaction.replace(R.id.frameLayout,frag)
        fragTransaction.commit()
    }
}