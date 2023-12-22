package com.eng_abdelrahmman_hussien.movieapp.uilayer.fragments.displayplanfeaturesfragment

import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DisplayPlanFeaturesFragmentViewModel:ViewModel() {

    private val _imagesList:MutableLiveData<List<ImageView>> = MutableLiveData()
    val imagesList:LiveData<List<ImageView>>
        get() = _imagesList

    fun getImages(imgList:List<ImageView>){
        _imagesList.value=imgList


    }


}