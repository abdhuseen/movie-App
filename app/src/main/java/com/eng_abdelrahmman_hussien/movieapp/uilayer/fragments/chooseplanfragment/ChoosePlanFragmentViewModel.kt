package com.eng_abdelrahmman_hussien.movieapp.uilayer.fragments.chooseplanfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eng_abdelrahmman_hussien.movieapp.datalayer.model.Plan
import com.eng_abdelrahmman_hussien.movieapp.datalayer.repositories.PlanRepository
import java.lang.reflect.Constructor
import javax.inject.Inject

class ChoosePlanFragmentViewModel @Inject constructor(val planRepository: PlanRepository):ViewModel() {

    private val _plansList:MutableLiveData<List<Plan>> = MutableLiveData()
    val plansList:LiveData<List<Plan>>
        get() = _plansList

    fun getPlans(){
        val plansList=planRepository.getPlans()
        _plansList.value=plansList
    }

}