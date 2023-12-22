package com.eng_abdelrahmman_hussien.movieapp.datalayer.repositories

import com.eng_abdelrahmman_hussien.movieapp.datalayer.datasources.service.API
import com.eng_abdelrahmman_hussien.movieapp.datalayer.model.Movie

class MovieRepository(private val movieApi:API) {

    suspend fun getMovies():List<Movie>{

        return movieApi.getMovies()
    }
    suspend fun getMovieDetailsById(id:String):Movie{

      return  movieApi.getMovieDetailsById(id)
    }
}