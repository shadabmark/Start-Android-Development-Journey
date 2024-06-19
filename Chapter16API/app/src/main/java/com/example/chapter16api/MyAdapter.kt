package com.example.chapter16api

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(private val context: Activity, private val productArrayList: List<Product>):
RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    class MyViewHolder(itemView : View):RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var image: ShapeableImageView
        var price: TextView
        val brand: TextView

        init {
            title = itemView.findViewById(R.id.productName)
            image = itemView.findViewById(R.id.productImage)
            price = itemView.findViewById(R.id.price)
            brand = itemView.findViewById(R.id.brand)
        }
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
    val itemView = LayoutInflater.from(context).inflate(R.layout.eachitem,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem = productArrayList[position]
        holder.title.text = currentItem.title
        holder.price.text = currentItem.price.toString()
        holder.brand.text = currentItem.brand
        // image view , how to show image in image view if the image is in from of url using 3rd party Library
        // picasso
        Picasso.get().load(currentItem.thumbnail).into(holder.image);


    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }
}