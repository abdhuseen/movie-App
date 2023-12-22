package com.eng_abdelrahmman_hussien.movieapp.datalayer.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(@PrimaryKey(autoGenerate = true) val id:Long=0, @ColumnInfo("username") var username: String?,@ColumnInfo("password")  var password: String?){
       val userid:Long
        get() = id
    var user_username: String?
        get() = username
        set(value) {username=value}
    var userPassword: String?
        get() = password
        set(value) {password=value}

}
