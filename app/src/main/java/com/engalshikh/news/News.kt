package com.engalshikh.news

import com.google.gson.annotations.SerializedName

 data class News(
                   @SerializedName("Art_title")
                    var title: String ="",
                    @SerializedName("Art_subject")
                    var sub:String="",
                    @SerializedName("Art_image")
                    var image:String="",
                    @SerializedName("Art_date")
                    var time:String="",
                    @SerializedName("cat_title")
                    var cat:String=""
) {
}