package com.eng_abdelrahmman_hussien.movieapp.uilayer.fragments.adventurefragment

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
import com.eng_abdelrahmman_hussien.movieapp.databinding.FragmentAdventureBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdventureFragment : Fragment() {
private lateinit var adventureBinding:FragmentAdventureBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        adventureBinding=FragmentAdventureBinding.inflate(inflater,container,false)
        adventureBinding.lifecycleOwner=this
        return adventureBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycler: RecyclerView =view.findViewById(R.id.recycler1)
        recycler.layoutManager= GridLayoutManager(context,2)//show 2 movies at each row
        val adventureViewModel=ViewModelProvider(this)[AdventureFragmentViewModel::class.java]
        adventureViewModel.fetchMovies()//retrieve movies from api
        adventureViewModel.movieList.observe(viewLifecycleOwner, Observer {
           //fill movies list
            recycler.adapter= MovieListAdapter(it)
        })

    }
}