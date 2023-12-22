package com.eng_abdelrahmman_hussien.movieapp.datalayer.datasources.userDataStorePreferences
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.eng_abdelrahmman_hussien.movieapp.datalayer.model.User
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
object UserDataStore {
    private const val DATA_STORE_NAME="USER_DATA_STORE"
    private const val USER_USERNAME_KEY="USER_USERNAME"
    private const val USER_PASSWORD_KEY="USER_PASSWORD"
    private val Context.dataStore:DataStore<Preferences> by preferencesDataStore(name = DATA_STORE_NAME)

    suspend fun insertUserData(context: Context,user: User){
//store username and password in datastore
        context.dataStore.edit {
            it[stringPreferencesKey(USER_USERNAME_KEY)]=user.user_username.toString()
            it[stringPreferencesKey(USER_PASSWORD_KEY)]=user.userPassword.toString()
        }


    }

    suspend fun modifyUserData(context: Context, user: User){

        //update  username and password in datastore

        context.dataStore.edit {
            it[stringPreferencesKey(USER_USERNAME_KEY)]=user.user_username.toString()
            it[stringPreferencesKey(USER_PASSWORD_KEY)]=user.userPassword.toString()
        }

    }

   suspend fun deleteUserData(context: Context){

//delete username and password in datastore
       context.dataStore.edit {

           it.clear()

       }
   }

    suspend  fun getUserData(context: Context): User {
        //retrieve username and password from datastore
    return   context.dataStore.data.map { preferences ->
          User(
              username = preferences[stringPreferencesKey(USER_USERNAME_KEY)] ?: "",
              password = preferences[stringPreferencesKey(USER_PASSWORD_KEY)] ?: ""
          )
      }.first()
  }


}