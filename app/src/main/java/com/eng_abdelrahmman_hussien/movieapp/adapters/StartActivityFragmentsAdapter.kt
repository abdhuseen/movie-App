package com.eng_abdelrahmman_hussien.movieapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.eng_abdelrahmman_hussien.movieapp.uilayer.fragments.firstinitialfragment.FirstInitialFragment
import com.eng_abdelrahmman_hussien.movieapp.uilayer.fragments.secondinitialfragment.SecondInitialFragment
import com.eng_abdelrahmman_hussien.movieapp.uilayer.fragments.thirdinitialfragment.ThirdInitialFragment

class StartActivityFragmentsAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle):
    FragmentStateAdapter(fragmentManager,lifecycle) {
        //fill the started fragments of the app in start activity
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when(position){

            1 -> return SecondInitialFragment()
            2 -> return ThirdInitialFragment()

        }

        return FirstInitialFragment()
    }
}