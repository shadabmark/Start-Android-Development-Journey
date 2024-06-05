package com.example.chapter14listview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)
        val taskList = arrayListOf<String>()
        taskList.add("Attend Exam")
        taskList.add("Complete the app dev")
        taskList.add("Buy a Milk Pouch")
        taskList.add("Work on Resume")
        taskList.add("Go to the USA")
        val adapterForMyListView = ArrayAdapter(this,android.R.layout.simple_list_item_1,taskList)
        listView.adapter = adapterForMyListView

        listView.setOnItemClickListener { parent, view, position, id ->
            val text = "Clicked on item: "+(view as TextView).text.toString()
            Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
        }
    }
}