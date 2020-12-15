package API

import com.engalshikh.news.News
import com.engalshikh.news.NewsResponse
import retrofit2.Call
import retrofit2.http.GET


interface NewsApi {

    @GET("/API/api/api_news.php")
    fun fetchContents(): Call<NewsResponse>

    @GET("/API/api/api_news.php")
    fun fetchSportNews(): Call<NewsResponse>

}