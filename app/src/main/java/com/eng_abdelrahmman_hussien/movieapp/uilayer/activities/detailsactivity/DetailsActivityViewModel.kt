package com.eng_abdelrahmman_hussien.movieapp.uilayer.activities.detailsactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eng_abdelrahmman_hussien.movieapp.datalayer.model.Movie
import com.eng_abdelrahmman_hussien.movieapp.datalayer.repositories.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsActivityViewModel @Inject constructor(val movieRepository: MovieRepository):ViewModel() {

    private val _movie:MutableLiveData<Movie> = MutableLiveData()
    val movieData:LiveData<Movie>
        get() = _movie
    fun getMovieData(id:String){

       viewModelScope.launch {

           val data=movieRepository.getMovieDetailsById(id)
           _movie.value=data

       }

    }
}