package com.engalshikh.news

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class NewsFragment : Fragment() {
    private lateinit var newsViewModel: NewsViewModel



    private lateinit var newsRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newsViewModel =
            ViewModelProviders.of(this).get(NewsViewModel::class.java)




    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var newsF=NewsFetchr()
        val earthquakeLiveData=newsF.fetchContents()
        earthquakeLiveData.observe(this, Observer {
            Log.d("test", "Response received: ${it}")
            newsRecyclerView.adapter = NewsAdapter(it)
        })
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_news, container, false)
      newsRecyclerView=view.findViewById(R.id.recycler_view)
        newsRecyclerView.layoutManager= LinearLayoutManager(context)

        return view
    }

    companion object {
        fun newInstance() = NewsFragment()
    }

    private  inner class NewsHolder(view: View) : RecyclerView.ViewHolder(view){

        val image=view.findViewById(R.id.image) as TextView
        val title=view.findViewById(R.id.title) as TextView
        val det=view.findViewById(R.id.det) as TextView
        val time=view.findViewById(R.id.time) as TextView


        var news=News()
        fun bind(news: News){

            image.text=news.image
            title.text=news.title
            det.text=news.sub
            time.text=news.time



    }}

    inner class NewsAdapter(var news: List<News>) :
            RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            var view: View
            view = layoutInflater.inflate(
                    R.layout.news_list,
                    parent, false
            )

            return NewsHolder(view)

        }


        override fun getItemCount(): Int {

            return news.size

        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

            val news=news[position]
            if(holder is NewsHolder)
                holder.bind(news)


        }
    }







}


