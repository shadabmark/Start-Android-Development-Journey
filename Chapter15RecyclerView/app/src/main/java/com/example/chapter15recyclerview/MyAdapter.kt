package com.example.chapter15recyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private var newsArraylist: ArrayList<News>, var context : Activity):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    class MyViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        val hTitle = itemView.findViewById<TextView>(R.id.headingTitle)
            val hImage = itemView.findViewById<ShapeableImageView>(R.id.headingImage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.eachitem,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        var currentItem = newsArraylist[position]
        holder.hTitle.text = currentItem.newsHeading
        holder.hImage.setImageResource(currentItem.newsImage)

    }

    override fun getItemCount(): Int {
        return newsArraylist.size

    }
}