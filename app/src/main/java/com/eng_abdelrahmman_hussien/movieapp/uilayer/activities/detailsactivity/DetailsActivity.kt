package com.eng_abdelrahmman_hussien.movieapp.uilayer.activities.detailsactivity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.eng_abdelrahmman_hussien.movieapp.databinding.ActivityDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {
    private lateinit var detailsBinding:ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailsBinding=ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(detailsBinding.root)
        val movieId:String=intent.getStringExtra("movieId") as String //get movie id to retrieve data from api
        val details_viewModel=ViewModelProvider(this)[DetailsActivityViewModel::class.java]
        details_viewModel.getMovieData(movieId)
        details_viewModel.movieData.observe(this, Observer {

            detailsBinding.textViewShowMovieName.text=it.nameProp
            detailsBinding.imageViewShowMovieImage.load(it.imgUrlProp)
            detailsBinding.textViewDescription.text=it.descriptionProp
            detailsBinding.btnMoviePlayer.setOnClickListener {
                view->
                val showMovie=Intent()
                showMovie.action=Intent.ACTION_VIEW
                showMovie.data= Uri.parse(it.trailer_youtubelinkProp)
                startActivity(showMovie)

            }



        })



    }
}