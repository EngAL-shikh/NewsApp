package API

import com.engalshikh.news.News
import com.engalshikh.news.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsApi {

    @GET("/API/api/api_news.php")
    fun fetchContents(): Call<NewsResponse>

    @GET("/API/api/api_news.php?")
    fun fetchtype(@Query("type") type: Int): Call<NewsResponse>
    //fun fetchtype(type:Int): Call<NewsResponse>
}