package com.aydinpolat.movieapp.data.remote

import com.aydinpolat.movieapp.data.remote.models.detail.DetailDto
import com.aydinpolat.movieapp.data.remote.models.genre.GenresDto
import com.aydinpolat.movieapp.data.remote.models.latest.LatestDto
import com.aydinpolat.movieapp.data.remote.models.popular.PopularDto
import com.aydinpolat.movieapp.data.remote.models.similar.SimilarDto
import com.aydinpolat.movieapp.data.remote.models.top_rated.TopRatedDto
import com.aydinpolat.movieapp.data.remote.models.up_coming.UpComingDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET("/3/movie/top_rated?")
    fun getTopRatedMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): TopRatedDto

    @GET("/3/movie/upcoming?")
    fun getUpComingMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ) : UpComingDto

    @GET("/3/movie/popular?")
    fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ) : PopularDto

    @GET("/3/movie/latest?")
    fun getLatestMovie(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
    ) : LatestDto

    @GET("/3/movie/{movie_id}/similar?")
    fun getSimilarMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int,
        @Path("movie_id") movieId: String
    ) : SimilarDto

    @GET("/3/movie/{movie_id}?")
    fun getMovieDetail(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Path("movie_id") movieId: String
    ) : DetailDto

    @GET("/3/genre/movie/list?")
    fun getGenreList(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ) : GenresDto
}