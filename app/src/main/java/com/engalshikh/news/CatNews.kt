package com.engalshikh.news

import com.google.gson.annotations.SerializedName

data class CatNews (
    @SerializedName("cat_title")
    var cattitle: String ="",
    @SerializedName("sub_cat_title")
    var subsubtitle:String="",
    @SerializedName("sub_sub_cat_title")
    var sub2title:String=""
){
}