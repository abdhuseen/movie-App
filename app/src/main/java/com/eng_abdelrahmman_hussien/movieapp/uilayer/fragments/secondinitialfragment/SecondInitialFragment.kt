package com.eng_abdelrahmman_hussien.movieapp.uilayer.fragments.secondinitialfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.eng_abdelrahmman_hussien.movieapp.R
import com.eng_abdelrahmman_hussien.movieapp.databinding.FragmentSecondInitialBinding

class SecondInitialFragment : Fragment() {
    private lateinit var secondInitialBinding:FragmentSecondInitialBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        secondInitialBinding=FragmentSecondInitialBinding.inflate(inflater,container,false)
        secondInitialBinding.lifecycleOwner=this
        return secondInitialBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val img=secondInitialBinding.imageViewImage2
        img.setImageResource(R.drawable.no_contracts)


    }
}