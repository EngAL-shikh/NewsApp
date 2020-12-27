package com.engalshikh.news

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoreDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_detail)

        var title:TextView=findViewById(R.id.title_moredetial)
        var det:TextView=findViewById(R.id.det_more)
        var date:TextView=findViewById(R.id.date_more)

        var titleNews= intent.getStringExtra("title")
        var detials= intent.getStringExtra("det")
        var time= intent.getStringExtra("time")

        title.setText(titleNews)
        det.setText(detials)
        date.setText(time)

    }
}