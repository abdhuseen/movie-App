package com.eng_abdelrahmman_hussien.movieapp.uilayer.fragments.thirdinitialfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.eng_abdelrahmman_hussien.movieapp.R
import com.eng_abdelrahmman_hussien.movieapp.databinding.FragmentThirdInitialBinding

class ThirdInitialFragment : Fragment() {
    private lateinit var thirdBinding:FragmentThirdInitialBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        thirdBinding=FragmentThirdInitialBinding.inflate(inflater,container,false)
        thirdBinding.lifecycleOwner=this
        return thirdBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val img=thirdBinding.imageViewImage3
        img.setImageResource(R.drawable.watch_movie)


    }
}