package com.eng_abdelrahmman_hussien.movieapp.uilayer.fragments.loginfragment

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eng_abdelrahmman_hussien.movieapp.datalayer.datasources.userDataStorePreferences.UserDataStore
import com.eng_abdelrahmman_hussien.movieapp.datalayer.model.User
import com.eng_abdelrahmman_hussien.movieapp.datalayer.repositories.UserRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginFragmentViewModel @Inject constructor( val userRepository: UserRepository):ViewModel() {
    private val _user: MutableLiveData<User?> = MutableLiveData()
    val user: LiveData<User?>
        get() = _user
    fun getUser(userName:String,pass:String){
        viewModelScope.launch {
            val user=userRepository.getUser(userName,pass)
            _user.value=user
        }

    }



    fun insertUserData(context: Context,user: User){

        viewModelScope.launch {

            val user= UserDataStore.insertUserData(context,user)

        }
    }



}