package com.aydinpolat.movieapp.data.repository

import com.aydinpolat.movieapp.common.Constants
import com.aydinpolat.movieapp.data.remote.MovieApi
import com.aydinpolat.movieapp.data.remote.models.detail.DetailDto
import com.aydinpolat.movieapp.data.remote.models.genre.GenresDto
import com.aydinpolat.movieapp.data.remote.models.latest.LatestDto
import com.aydinpolat.movieapp.data.remote.models.popular.PopularDto
import com.aydinpolat.movieapp.data.remote.models.similar.SimilarDto
import com.aydinpolat.movieapp.data.remote.models.top_rated.TopRatedDto
import com.aydinpolat.movieapp.data.remote.models.up_coming.UpComingDto
import com.aydinpolat.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class MoviesRepositoryImplementation @Inject constructor(
    private val api: MovieApi
) : MovieRepository {
    override suspend fun getTopRatedMovies(): TopRatedDto {
        return api.getTopRatedMovies(Constants.AUTH_TOKEN, Constants.LANGUAGE, 1)
    }

    override suspend fun getUpComingMovies(): UpComingDto {
        return api.getUpComingMovies(Constants.AUTH_TOKEN, Constants.LANGUAGE, 1)
    }

    override suspend fun getPopularMovies(): TopRatedDto {
        return api.getPopularMovies(Constants.AUTH_TOKEN, Constants.LANGUAGE, 1)
    }

    override suspend fun getLatestMovie(): LatestDto {
        return api.getLatestMovie(Constants.AUTH_TOKEN, Constants.LANGUAGE)
    }

    override suspend fun getSimilarMovies(): SimilarDto {
        return api.getSimilarMovies(Constants.AUTH_TOKEN, Constants.LANGUAGE, 1, "278")
    }

    override suspend fun getMovieDetail(): DetailDto {
        return api.getMovieDetail(Constants.AUTH_TOKEN, Constants.LANGUAGE, "278")
    }

    override suspend fun getGenreList(): GenresDto {
        return api.getGenreList(Constants.AUTH_TOKEN, Constants.LANGUAGE)
    }
}