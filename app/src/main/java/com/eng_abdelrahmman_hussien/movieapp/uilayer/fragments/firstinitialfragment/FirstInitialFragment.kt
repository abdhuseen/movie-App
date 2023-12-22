package com.eng_abdelrahmman_hussien.movieapp.uilayer.fragments.firstinitialfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.eng_abdelrahmman_hussien.movieapp.R
import com.eng_abdelrahmman_hussien.movieapp.databinding.FragmentFirstInitialBinding

class FirstInitialFragment : Fragment() {
    private lateinit var firstInitialBinding:FragmentFirstInitialBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        firstInitialBinding=FragmentFirstInitialBinding.inflate(inflater,container,false)
        firstInitialBinding.lifecycleOwner=this
        return firstInitialBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val img=firstInitialBinding.imageViewImage1
        img.setImageResource(R.drawable.devices)
    }
}