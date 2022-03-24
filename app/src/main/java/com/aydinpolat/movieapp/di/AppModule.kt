package com.aydinpolat.movieapp.di

import android.graphics.Movie
import com.aydinpolat.movieapp.common.Constants
import com.aydinpolat.movieapp.data.remote.MovieApi
import com.aydinpolat.movieapp.data.repository.MoviesRepositoryImplementation
import com.aydinpolat.movieapp.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieApi(): MovieApi{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(MovieApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api: MovieApi): MovieRepository{
        return MoviesRepositoryImplementation(api)
    }
}