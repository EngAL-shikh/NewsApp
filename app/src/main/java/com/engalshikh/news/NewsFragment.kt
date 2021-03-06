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
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class NewsFragment : Fragment() {
    private lateinit var newsViewModel: NewsViewModel

    private lateinit var newsRecyclerView: RecyclerView
    private lateinit var newsRecyclerView2: RecyclerView
    var type:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newsViewModel =
            ViewModelProviders.of(this).get(NewsViewModel::class.java)
        type=arguments?.getSerializable("type")as String



    }
//
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var newsF=NewsFetchr()

    if (type=="gnral"){

        val newsLiveData=newsF.fetchContents()
        newsLiveData.observe(this, Observer {
            Log.d("test", "Response received: ${it}")
            newsRecyclerView.adapter = NewsAdapter(it)
        })

       newsRecyclerView2.visibility=View.VISIBLE
        val catLiveData=newsF.fetchCat()
        catLiveData.observe(this, Observer {
            Log.d("test", "Response received: ${it}")
            newsRecyclerView2.adapter = CatAdapter(it)
        })
    }else if(type=="sport"){

        val newsLiveData=newsF.sportPolticNews()
        newsLiveData.observe(this, Observer {
            Log.d("test", "Response received: ${it}")
            newsRecyclerView.adapter = NewsAdapter(it)
    })

    }else{
        val newsLiveData=newsF.fetchPolticNews()
        newsLiveData.observe(this, Observer {
            Log.d("test", "Response received: ${it}")
            newsRecyclerView.adapter = NewsAdapter(it)
        })

    }




}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_news, container, false)
        newsRecyclerView=view.findViewById(R.id.recycler_view)
        newsRecyclerView.layoutManager=LinearLayoutManager(context)



        newsRecyclerView2=view.findViewById(R.id.recycler_view2)
        newsRecyclerView2.layoutManager=
           GridLayoutManager(context,1,LinearLayoutManager.HORIZONTAL,false)

        return view
    }

    companion object{
        fun newInstance(data:String):NewsFragment{
            val args=Bundle().apply {
                putSerializable("type",data)
            }
            return  NewsFragment().apply {
                arguments=args
            }
        }
    }

    
    // News Holder 
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



    }
       

    }
    
    // NewsAdapter
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
    
    
    
    
    // Cat Holder 
    private  inner class CatHolder(view: View) : RecyclerView.ViewHolder(view){


        val cattitle=view.findViewById(R.id.cattitle) as TextView
        val sub_cat_title=view.findViewById(R.id.sub_cat_title) as TextView
        val sub2_cat_title=view.findViewById(R.id.sub2_cat_title) as TextView


        var catnews=CatNews()
        fun bind2(catnews: CatNews){


            cattitle.text=catnews.cattitle
            sub_cat_title.text=catnews.subsubtitle
            sub2_cat_title.text=catnews.sub2title


        }

    }

    //CatAdapter
    inner class CatAdapter(var catnews: List<CatNews>) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            var view: View



            view = layoutInflater.inflate(
                R.layout.news_cat_list,
                parent, false
            )

            return CatHolder(view)

        }


        override fun getItemCount(): Int {

            return catnews.size

        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

            val cat=catnews[position]
            if(holder is CatHolder)
                holder.bind2(cat)


        }
    }


}


