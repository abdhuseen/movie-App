package com.eng_abdelrahmman_hussien.movieapp.uilayer.fragments.chooseplanfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.eng_abdelrahmman_hussien.movieapp.adapters.PlansCardAdapter
import com.eng_abdelrahmman_hussien.movieapp.databinding.FragmentChoosePlanBinding

class ChoosePlanFragment : Fragment() {
    private lateinit var chooseBinding:FragmentChoosePlanBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        chooseBinding=FragmentChoosePlanBinding.inflate(inflater,container,false)
        chooseBinding.lifecycleOwner=this
        return chooseBinding.root//inflater.inflate(R.layout.fragment_choose_plan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val chooseVm=ViewModelProvider(this)[ChoosePlanFragmentViewModel::class.java]
        val recy=chooseBinding.plansRecycler
        recy.layoutManager=LinearLayoutManager(this@ChoosePlanFragment.context,LinearLayoutManager.HORIZONTAL,false)
        chooseVm.getPlans()//retrieve plans of subscription
        chooseVm.plansList.observe(viewLifecycleOwner){
            recy.adapter= PlansCardAdapter(it)
        }

    }
}