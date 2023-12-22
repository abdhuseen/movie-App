package com.eng_abdelrahmman_hussien.movieapp.uilayer.activities.homeactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eng_abdelrahmman_hussien.movieapp.adapters.HomeActivityFragmentsAdapter
import com.eng_abdelrahmman_hussien.movieapp.databinding.ActivityHomeBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var homeBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)
        //connect tabs with view pager where in this activity user browse movies by categorises
        val tabSTitle= arrayOf("Action","Comedy","Adventure")
        homeBinding.viewPager.adapter= HomeActivityFragmentsAdapter(supportFragmentManager,lifecycle)
        TabLayoutMediator(homeBinding.tabLayout,homeBinding.viewPager){
            tab,position -> tab.text=tabSTitle[position]
        }.attach()

    }
}