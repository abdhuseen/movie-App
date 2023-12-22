package com.eng_abdelrahmman_hussien.movieapp.uilayer.fragments.actionfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eng_abdelrahmman_hussien.movieapp.adapters.MovieListAdapter
import com.eng_abdelrahmman_hussien.movieapp.databinding.FragmentActionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActionFragment: Fragment() {
    private lateinit var actionBinding:FragmentActionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        actionBinding = FragmentActionBinding.inflate(inflater, container, false)
       actionBinding.lifecycleOwner=this
        return actionBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler:RecyclerView=actionBinding.actionMovieList
        recycler.layoutManager=GridLayoutManager(context,2)//show two movies at same row
        val actionViewModel=ViewModelProvider(this)[ActionFragmentViewModel::class.java]
        actionViewModel.fetchMovies()//retrieve movies from api
        actionViewModel.movieList.observe(viewLifecycleOwner, Observer {

            //fill movies list
            recycler.adapter= MovieListAdapter(it)
        })



    }


}
