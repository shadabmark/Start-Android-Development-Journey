package com.example.chapter14project2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var userArrayList : ArrayList<User>
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = arrayOf("Shadab Mark","Saumya","Suhel","Pradeep","Noor","Arman","Salman Khan","Elon Musk","Sahil")

        val lastMsg = arrayOf("Hey how are you?","I am fine","Good","Looking Amazing","Fine","Kaise ho saare","what happen","Do you lier","No Buddy")

        val lastMsgTime = arrayOf("6:45 PM","8:58 PM","9:45 PM","10:28 PM","10:30 PM","10:50 PM","8:55 PM","9:35 PM","11:30 PM")

        val phoneNumber = arrayOf("5487698547","5487412547","5487965874","2054781047","8957489820","5879896320","9487975874","9754781047","8557589820")

        val imgId = intArrayOf(R.drawable.pic2, R.drawable.pic1,R.drawable.pic3,
            R.drawable.family,R.drawable.mark3,R.drawable.modi1,R.drawable.pop2,R.drawable.pop3,R.drawable.pop1)

        userArrayList = ArrayList()

        for (eachIndex in name.indices){
            val user = User(name[eachIndex],lastMsg[eachIndex],lastMsgTime[eachIndex],phoneNumber[eachIndex],
                imgId[eachIndex])

            userArrayList.add(user)
        }

        val listView = findViewById<ListView>(R.id.listView)

        listView.isClickable = true
        listView.adapter = MyAdapter(this,userArrayList)

        listView.setOnItemClickListener { parent, view, position, id ->
            val userName = name[position]
            val userPhone = phoneNumber[position]
            val image = imgId[position]

            val info = Intent(this,UserInfoActivity::class.java)
            info.putExtra("name",userName)
            info.putExtra("phone",userPhone)
            info.putExtra("image",image)
            startActivity(info)
        }

    }
}