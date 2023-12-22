package com.eng_abdelrahmman_hussien.movieapp.uilayer.fragments.setuppaypalfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eng_abdelrahmman_hussien.movieapp.databinding.FragmentSetUpPaypalBinding

class SetUpPaypalFragment : Fragment() {
    private lateinit var setupPaypalBinding:FragmentSetUpPaypalBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setupPaypalBinding=FragmentSetUpPaypalBinding.inflate(inflater,container,false)
        setupPaypalBinding.lifecycleOwner=this
        return setupPaypalBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}