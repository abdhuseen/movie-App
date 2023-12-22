package com.eng_abdelrahmman_hussien.movieapp.datalayer.datasources.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.eng_abdelrahmman_hussien.movieapp.datalayer.model.User
//define database class
@Database(entities = [User::class], version = 1, exportSchema = false)
 abstract class MovieDatabase:RoomDatabase() {
     abstract fun userDao(): UserDao
}