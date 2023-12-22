package com.eng_abdelrahmman_hussien.movieapp.di
import android.content.Context
import androidx.room.Room
import com.eng_abdelrahmman_hussien.movieapp.datalayer.datasources.localDB.MovieDatabase
import com.eng_abdelrahmman_hussien.movieapp.datalayer.datasources.localDB.UserDao
import com.eng_abdelrahmman_hussien.movieapp.datalayer.datasources.service.API
import com.eng_abdelrahmman_hussien.movieapp.datalayer.repositories.MovieRepository
import com.eng_abdelrahmman_hussien.movieapp.datalayer.repositories.PlanRepository
import com.eng_abdelrahmman_hussien.movieapp.datalayer.repositories.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMovieDB(@ApplicationContext context: Context):MovieDatabase{

        return Room.databaseBuilder(context.applicationContext,
            MovieDatabase::class.java,"movie_database").build()
    }

    @Singleton
    @Provides
    fun provideUserDao(database: MovieDatabase):UserDao{

        return database.userDao()
    }

    @Singleton
    @Provides
    fun provideUserRepository(userDao: UserDao): UserRepository {
        return UserRepository(userDao)
    }

    @Singleton
    @Provides
    fun provideMovieApi():API{

        return Retrofit.Builder().baseUrl("https://imdb-top-100-movies.p.rapidapi.com").addConverterFactory(GsonConverterFactory.create()).build().create(API::class.java)
    }
    @Singleton
    @Provides
    fun provideMovieRepository(movieApi:API): MovieRepository {

        return MovieRepository(movieApi)
    }

    @Singleton
    @Provides
    fun providePlanRepository(): PlanRepository {

        return PlanRepository()
    }


}