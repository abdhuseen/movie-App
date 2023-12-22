package com.eng_abdelrahmman_hussien.movieapp.uilayer.activities.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eng_abdelrahmman_hussien.movieapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //host activity of the navigation system in our app (app_graph.xml)
    }
}