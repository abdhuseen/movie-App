package com.eng_abdelrahmman_hussien.movieapp.uilayer.activities.startactivity

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eng_abdelrahmman_hussien.movieapp.datalayer.datasources.userDataStorePreferences.UserDataStore
import com.eng_abdelrahmman_hussien.movieapp.datalayer.model.User
import kotlinx.coroutines.launch
class StartActivityViewModel :ViewModel() {
    private val _userData:MutableLiveData<User> = MutableLiveData()
    val userData:LiveData<User>
        get() = _userData

    fun getUserData(context: Context){

        viewModelScope.launch {

            val user= UserDataStore.getUserData(context)
            _userData.value=user
        }
    }


}