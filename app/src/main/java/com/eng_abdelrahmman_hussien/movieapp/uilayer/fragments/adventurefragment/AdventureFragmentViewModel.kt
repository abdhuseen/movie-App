package com.eng_abdelrahmman_hussien.movieapp.uilayer.fragments.adventurefragment

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
class AdventureFragmentViewModel @Inject constructor(val movieRepository: MovieRepository):ViewModel() {
    private val _movieList: MutableLiveData<List<Movie>> = MutableLiveData()
    val movieList: LiveData<List<Movie>>
        get() = _movieList

    fun fetchMovies(){

        viewModelScope.launch {

            val movies=movieRepository.getMovies()
            _movieList.value=movies

        }
    }
}