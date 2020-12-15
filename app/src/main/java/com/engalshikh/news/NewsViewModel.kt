package com.engalshikh.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class NewsViewModel:ViewModel() {

    val newsLiveData: LiveData<List<News>>
    val polticnewsLiveData: LiveData<List<News>>
    val sportnewsLiveData: LiveData<List<News>>
   val oddnewsLiveData: LiveData<List<News>>
    init {
        newsLiveData = NewsFetchr().fetchContents()
        polticnewsLiveData = NewsFetchr().fetchPolticNews()
        sportnewsLiveData = NewsFetchr().sportPolticNews()
        oddnewsLiveData = NewsFetchr().oddPolticNews()
    }

}