package com.eng_abdelrahmman_hussien.movieapp.uilayer.fragments.comedyfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eng_abdelrahmman_hussien.movieapp.R
import com.eng_abdelrahmman_hussien.movieapp.adapters.MovieListAdapter
import com.eng_abdelrahmman_hussien.movieapp.databinding.FragmentComedyBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComedyFragment : Fragment() {
private lateinit var comedyBinding:FragmentComedyBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        comedyBinding=FragmentComedyBinding.inflate(inflater,container,false)
        comedyBinding.lifecycleOwner=this

        return comedyBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycler: RecyclerView =view.findViewById(R.id.recycler2)

        val comedyViewModel=ViewModelProvider(this)[ComedyFragmentViewModel::class.java]

        recycler.layoutManager= GridLayoutManager(context,2)//show 2 movies at each row
       comedyViewModel.fetchMovies()//retrieve movies from api
        comedyViewModel.movieList.observe(viewLifecycleOwner, Observer {
            recycler.adapter= MovieListAdapter(it)//fill movies list
        })
    }
}