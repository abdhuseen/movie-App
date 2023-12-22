package com.eng_abdelrahmman_hussien.movieapp.uilayer.fragments.signupfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eng_abdelrahmman_hussien.movieapp.datalayer.model.User
import com.eng_abdelrahmman_hussien.movieapp.datalayer.repositories.UserRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class SignUpFragmentViewModel @Inject constructor(val userRepository: UserRepository):ViewModel() {
    private val _user:MutableLiveData<User?> = MutableLiveData()
    val user:LiveData<User?>
        get() = _user
    private val _users:MutableLiveData<List<User?>> = MutableLiveData()
    val users:LiveData<List<User?>>
        get() = _users

    fun insertUser(user: User){
       viewModelScope.launch {
           userRepository.insertUser(user)
       }

    }

    fun getUsers(){
           viewModelScope.launch {
               val allUsers=userRepository.getAllUsers()
               _users.value=allUsers
           }

    }



}