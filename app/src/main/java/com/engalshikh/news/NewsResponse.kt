package com.engalshikh.news

import com.google.gson.annotations.SerializedName


data class NewsResponse (

        @SerializedName("getAllRows")
      var newsR:List<News>
        ,
        @SerializedName("gettypeRows")
      var newsT:List<News>
)