package com.eng_abdelrahmman_hussien.movieapp.datalayer.datasources.service

import com.eng_abdelrahmman_hussien.movieapp.datalayer.model.Movie
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface API {
//define api keys and query for movies
    @GET("/")
    @Headers(
        "X-RapidAPI-Key: 4685114e64msh20786e1113e1507p151cbcjsn82e49f340dc5",
        "X-RapidAPI-Host: imdb-top-100-movies.p.rapidapi.com"
    )
    suspend fun getMovies():List<Movie>
    @GET("/{id}")
    @Headers(
        "X-RapidAPI-Key: 4685114e64msh20786e1113e1507p151cbcjsn82e49f340dc5",
        "X-RapidAPI-Host: imdb-top-100-movies.p.rapidapi.com"
    )
    suspend fun getMovieDetailsById(@Path("id")id:String): Movie
}