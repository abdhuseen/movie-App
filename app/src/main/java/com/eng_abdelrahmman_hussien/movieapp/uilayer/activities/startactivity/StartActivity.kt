package com.eng_abdelrahmman_hussien.movieapp.uilayer.activities.startactivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.eng_abdelrahmman_hussien.movieapp.R
import com.eng_abdelrahmman_hussien.movieapp.adapters.StartActivityFragmentsAdapter
import com.eng_abdelrahmman_hussien.movieapp.databinding.ActivityStartBinding
import com.eng_abdelrahmman_hussien.movieapp.uilayer.activities.homeactivity.HomeActivity
import com.eng_abdelrahmman_hussien.movieapp.uilayer.activities.mainactivity.MainActivity
class StartActivity : AppCompatActivity() {
    private lateinit var startBinding:ActivityStartBinding
    private lateinit var startVm:StartActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startBinding=ActivityStartBinding.inflate(layoutInflater)
        setContentView(startBinding.root)
        startVm=ViewModelProvider(this)[StartActivityViewModel::class.java]
        setSupportActionBar(startBinding.toolbar)
        if(isUserLoggedIn()){
            //check if user was logged in if its logged in before, app will navigate direct to home activity
            startActivity(Intent(this,HomeActivity::class.java))
        }
        startBinding.vp.setScrollIndicators(View.SCROLL_INDICATOR_LEFT,View.SCROLL_INDICATOR_RIGHT)
        startBinding.vp.adapter= StartActivityFragmentsAdapter(supportFragmentManager,lifecycle)

        startBinding.btnGetStarted.setOnClickListener {

            startActivity(Intent(this,MainActivity::class.java))


        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.start_activity_menu,menu)
        return true
    }

    private fun isUserLoggedIn() :Boolean {
        startVm.getUserData(applicationContext) //retrieve user data from data store
        return (startVm.userData.value?.user_username?.trim()!="")//if user has data so its logged in before
    }


}