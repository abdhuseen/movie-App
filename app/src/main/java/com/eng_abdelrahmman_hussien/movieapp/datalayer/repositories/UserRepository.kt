package com.eng_abdelrahmman_hussien.movieapp.datalayer.repositories

import com.eng_abdelrahmman_hussien.movieapp.datalayer.datasources.localDB.UserDao
import com.eng_abdelrahmman_hussien.movieapp.datalayer.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository(private val userDao: UserDao) {

    suspend fun getAllUsers(): List<User>{

       return withContext(Dispatchers.IO){
          userDao.getAllUsers()
        }


    }

    suspend fun getUser(userName:String,pass:String): User?{

        return withContext(Dispatchers.IO){
            userDao.getUser(userName,pass)
        }
    }

    suspend fun insertUser(user: User){
       withContext(Dispatchers.IO){

           userDao.insertUser(user)
       }
    }
}