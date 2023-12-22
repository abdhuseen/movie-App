package com.eng_abdelrahmman_hussien.movieapp.datalayer.datasources.localDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.eng_abdelrahmman_hussien.movieapp.datalayer.model.User

//Create DAO (Data Access Object)
@Dao
interface UserDao {
    @Query("SELECT * FROM users")
     suspend fun getAllUsers(): List<User>

    @Query("SELECT * FROM users WHERE username = :userName and password=:pass")
    suspend fun getUser(userName:String,pass:String): User?

    @Insert
    suspend fun insertUser(user: User)

    @Update
    suspend  fun updateUser(user: User)

    @Query("DELETE FROM users WHERE id = :userId")
    suspend fun deleteUser(userId: Long)
}