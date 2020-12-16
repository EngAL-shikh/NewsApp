package com.engalshikh.news


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var  tabLayout: TabLayout
    lateinit var tabViewPager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
//        val isFragmentContainerEmpty = savedInstanceState == null
//        if (isFragmentContainerEmpty) {
//            supportFragmentManager
//                .beginTransaction()
//                .add(R.id.fragmentContainer, NewsFragment.newInstance())
//                .commit()
//        }


        tabLayout=findViewById(R.id.taps)
        tabViewPager=findViewById(R.id.vp) as ViewPager2


        tabViewPager.adapter=object : FragmentStateAdapter(this){
            override fun getItemCount(): Int {
                return 3
            }

            override fun createFragment(position: Int): Fragment {
                return  when(position){

                    0->NewsFragment.newInstance("gnral")
                    1->NewsFragment.newInstance("poltic")
                    2->NewsFragment.newInstance("sport")
//                    1->InProgress.newInstance()
//                    2->Done.newInstance()

                    else->NewsFragment.newInstance("gnral")
                }
            }


        }

        TabLayoutMediator(tabLayout,tabViewPager){tab,position->
            tab.text=when(position){

                0->"Gnral"
                1->"Poltic"
                2->"Sport"
                else -> null
            }

        }.attach()
    }
}