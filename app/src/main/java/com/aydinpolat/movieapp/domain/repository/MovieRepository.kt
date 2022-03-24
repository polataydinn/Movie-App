package com.aydinpolat.movieapp.domain.repository

import com.aydinpolat.movieapp.data.remote.models.detail.DetailDto
import com.aydinpolat.movieapp.data.remote.models.genre.GenresDto
import com.aydinpolat.movieapp.data.remote.models.latest.LatestDto
import com.aydinpolat.movieapp.data.remote.models.popular.PopularDto
import com.aydinpolat.movieapp.data.remote.models.similar.SimilarDto
import com.aydinpolat.movieapp.data.remote.models.top_rated.TopRatedDto
import com.aydinpolat.movieapp.data.remote.models.up_coming.UpComingDto

interface MovieRepository {
    suspend fun getTopRatedMovies(): TopRatedDto
    suspend fun getUpComingMovies(): UpComingDto
    suspend fun getPopularMovies(): PopularDto
    suspend fun getLatestMovie(): LatestDto
    suspend fun getSimilarMovies(): SimilarDto
    suspend fun getMovieDetail(): DetailDto
    suspend fun getGenreList(): GenresDto
}