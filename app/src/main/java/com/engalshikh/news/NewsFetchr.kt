package com.engalshikh.news

import API.NewsApi
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsFetchr {

        var  newsApi:NewsApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.1.2")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsApi = retrofit.create(NewsApi::class.java)
    }

    fun fetchContents():LiveData<List<News>> {
        val responseLiveData: MutableLiveData<List<News>> = MutableLiveData()
        val newsRequest: Call<NewsResponse> = newsApi.fetchContents()
        newsRequest.enqueue(object : Callback<NewsResponse> {
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e("TAG", "Failed to fetch News", t)
            }
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>
            ) {

                val newsResponse:NewsResponse? = response.body()
                val news:List<News> = newsResponse?.newsR
                        ?: mutableListOf()
                Log.d("TAG", "Response received")
                responseLiveData.value = news
                Log.d("onResponse", news.toString())
            }
        })
        return responseLiveData

    }

    fun fetchPolticNews():LiveData<List<News>> {
        val responseLiveData: MutableLiveData<List<News>> = MutableLiveData()
        val newsRequest: Call<NewsResponse> = newsApi.fetchtype(1)
        newsRequest.enqueue(object : Callback<NewsResponse> {
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e("TAG", "Failed to fetch News", t)
            }
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>
            ) {

                val newsResponse:NewsResponse? = response.body()
                val news:List<News> = newsResponse?.newsT
                        ?: mutableListOf()
                Log.d("TAG", "Response received")
                responseLiveData.value = news
                Log.d("onResponse", news.toString())
            }
        })
        return responseLiveData

    }
    fun sportPolticNews():LiveData<List<News>> {
        val responseLiveData: MutableLiveData<List<News>> = MutableLiveData()
        val newsRequest: Call<NewsResponse> = newsApi.fetchtype(2)
        newsRequest.enqueue(object : Callback<NewsResponse> {
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e("TAG", "Failed to fetch News", t)
            }
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>
            ) {

                val newsResponse:NewsResponse? = response.body()
                val news:List<News> = newsResponse?.newsT

                        ?: mutableListOf()
                Log.d("TAG", "Response received")
                responseLiveData.value = news
                Log.d("onResponse", news.toString())
            }
        })
        return responseLiveData

    }
    fun oddPolticNews():LiveData<List<News>> {
        val responseLiveData: MutableLiveData<List<News>> = MutableLiveData()
        val newsRequest: Call<NewsResponse> = newsApi.fetchtype(3)
        newsRequest.enqueue(object : Callback<NewsResponse> {
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e("TAG", "Failed to fetch News", t)
            }
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>
            ) {

                val newsResponse:NewsResponse? = response.body()
                val news:List<News> = newsResponse?.newsT
                        ?: mutableListOf()
                Log.d("TAG", "Response received")
                responseLiveData.value = news
                Log.d("onResponse", news.toString())
            }
        })
        return responseLiveData

    }

    }


