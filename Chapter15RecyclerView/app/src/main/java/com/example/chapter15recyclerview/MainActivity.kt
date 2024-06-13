package com.example.chapter15recyclerview

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var myRecyclerView : RecyclerView
    private lateinit var newsArraylist : ArrayList<News>
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecyclerView = findViewById(R.id.recyclerView)

        var newsImageArray = arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img2,
            R.drawable.img3,
        )

        var newsHeadingArray = arrayOf(
            "U.K. Foreign Secretary James Cleverly raises issue of BBC tax searches with EAM Jaishankar",
                    "Cooking gas prices hiked by ₹50 for domestic, ₹350.50 for commercial cylinders",
                    "Joe Biden appoints two prominent Indian-American corporate leaders to his Export Council",
                    "Sergey Lavrov will raise suspected bombing of Nord Stream II at G20: Russian Foreign Ministry",
                    "Belarusian leader Lukashenko visits China amid Ukraine tensions",
                    "China rips new U.S. House committee on countering Beijing",
                    "Largest gathering of Foreign Ministers hosted by any G20 presidency: Foreign Secretary Vinay Kwatra",
            "U.K. Foreign Secretary James Cleverly raises issue of BBC tax searches with EAM Jaishankar",
            "Cooking gas prices hiked by ₹50 for domestic, ₹350.50 for commercial cylinders",
            "Joe Biden appoints two prominent Indian-American corporate leaders to his Export Council",
            "Sergey Lavrov will raise suspected bombing of Nord Stream II at G20: Russian Foreign Ministry",
            "Belarusian leader Lukashenko visits China amid Ukraine tensions",
            "China rips new U.S. House committee on countering Beijing",
            "Largest gathering of Foreign Ministers hosted by any G20 presidency: Foreign Secretary Vinay Kwatra"
        )

        val newsContent = arrayOf(
            getString(R.string.news_content),getString(R.string.news_content),
            getString(R.string.news_content),getString(R.string.news_content),
            getString(R.string.news_content),getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),getString(R.string.news_content),
            getString(R.string.news_content),getString(R.string.news_content),
            getString(R.string.news_content),getString(R.string.news_content),
            getString(R.string.news_content)
        )

        // to set hav bhav of item inside recyclerView, vertcially scrolling, horizontally, uniform grid
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        newsArraylist = arrayListOf<News>()

       for (index in newsImageArray.indices){
           val news = News(newsHeadingArray[index], newsImageArray[index],newsContent[index])

           newsArraylist.add(news)
       }
        var listView = MyAdapter(newsArraylist,this)
        myRecyclerView.adapter = listView
        listView.setItemClickListener(object : MyAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity,NewsDetailsActivity::class.java)
                intent.putExtra("heading",newsArraylist[position].newsHeading)
                intent.putExtra("imageId",newsArraylist[position].newsImage)
                intent.putExtra("newscontent",newsArraylist[position].newsContent)
                startActivity(intent)

            }
        })
    }
}