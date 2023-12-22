package com.eng_abdelrahmman_hussien.movieapp.adapters

import com.eng_abdelrahmman_hussien.movieapp.uilayer.fragments.actionfragment.ActionFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.eng_abdelrahmman_hussien.movieapp.uilayer.fragments.adventurefragment.AdventureFragment
import com.eng_abdelrahmman_hussien.movieapp.uilayer.fragments.comedyfragment.ComedyFragment
//TODO 1-DATA STORE ,2-DEPENDENCY INJECTION HILT ,3-CLEAN ARCHITECTURE
class HomeActivityFragmentsAdapter(fragmentManager:FragmentManager,lifecycle: Lifecycle):FragmentStateAdapter(fragmentManager,lifecycle) {
    //connect viewpager in home activity by categories movies
    override fun getItemCount()=3

    override fun createFragment(position: Int): Fragment {
        when(position){

            1 -> return ComedyFragment()
            2 -> return AdventureFragment()

        }

        return ActionFragment()
    }
}