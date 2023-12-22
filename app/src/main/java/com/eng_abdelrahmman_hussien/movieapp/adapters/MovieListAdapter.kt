package com.eng_abdelrahmman_hussien.movieapp.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.eng_abdelrahmman_hussien.movieapp.R
import com.eng_abdelrahmman_hussien.movieapp.datalayer.model.Movie
import com.eng_abdelrahmman_hussien.movieapp.uilayer.activities.detailsactivity.DetailsActivity

class MovieListAdapter(private val movieList:List<Movie>) :RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder>() {

    //fill each movie data in movie card
    inner class MovieListViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        val img:ImageView=itemView.findViewById(R.id.imageView_movieImage)
        val textViewTitle:TextView=itemView.findViewById(R.id.textView_movie_title)
        val textViewRating:TextView=itemView.findViewById(R.id.textView_rating)
        val movieCard:CardView=itemView.findViewById(R.id.movieCard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.movie_list,parent,false)

        return MovieListViewHolder(itemView)
    }

    override fun getItemCount()=movieList.size

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.img.load(movieList[position].imgUrlProp){

        }
        holder.textViewTitle.text=movieList[position].nameProp
        holder.textViewRating.text=movieList[position].ratingProp.toString()
        //when movie card clicked app navigate to movie details activity
        holder.movieCard.setOnClickListener {

            val intent=Intent(holder.movieCard.context,DetailsActivity::class.java)
            intent.putExtra("movieId",movieList[position].idProp)
            holder.movieCard.context.startActivity(intent)

        }


    }

}