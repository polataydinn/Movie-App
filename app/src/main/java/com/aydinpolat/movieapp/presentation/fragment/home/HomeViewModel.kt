package com.aydinpolat.movieapp.presentation.fragment.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aydinpolat.movieapp.common.Resource
import com.aydinpolat.movieapp.data.remote.models.genre.Genre
import com.aydinpolat.movieapp.data.remote.models.genre.GenresDto
import com.aydinpolat.movieapp.data.remote.models.top_rated.TopRatedDto
import com.aydinpolat.movieapp.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {
    private val _topRatedState = MutableStateFlow(TopRatedListState())
    val topRatedState: StateFlow<TopRatedListState> get() = _topRatedState

    private val _popularState = MutableStateFlow(PopularListState())
    val popularState: StateFlow<PopularListState> get() = _popularState

    private val _genreState = MutableStateFlow(GenreListState())
    val genreState: StateFlow<GenreListState> get() = _genreState

    init {
        viewModelScope.launch {
            getGenreList()
            getTopRatedMovies()
            getPopularMovies()
        }
    }

    private fun getGenreList() {
        flow<Resource<GenresDto>> {
            try {
                emit(Resource.Loading<GenresDto>())
                emit(Resource.Success<GenresDto>(repository.getGenreList()))
            }catch (e: HttpException) {
                emit(
                    Resource.Error<GenresDto>(
                        e.localizedMessage ?: "An unexpected error occured"
                    )
                )
            } catch (e: IOException) {
                emit(Resource.Error<GenresDto>("Couldn't reach server check your internet connection"))
            }
        }.onEach { resource ->
            when(resource){
                is Resource.Success -> {
                    _genreState.value = GenreListState(genres = resource.data)
                }
                is Resource.Error -> {
                    _genreState.value = GenreListState(error = resource.message ?: "An unexcepted error occurred")
                }
                is Resource.Loading -> {
                    _genreState.value = GenreListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getPopularMovies() {
        flow<Resource<TopRatedDto>> {
            try {
                emit(Resource.Loading<TopRatedDto>())
                emit(Resource.Success<TopRatedDto>(repository.getPopularMovies()))
            } catch (e: HttpException) {
                emit(
                    Resource.Error<TopRatedDto>(
                        e.localizedMessage ?: "An unexpected error occured"
                    )
                )
            } catch (e: IOException) {
                emit(Resource.Error<TopRatedDto>("Couldn't reach server check your internet connection"))
            }
        }.onEach { resource ->
            when (resource) {
                is Resource.Success -> {
                    _popularState.value = PopularListState(movies = resource.data)
                }
                is Resource.Error -> {
                    _popularState.value =
                        PopularListState(error = resource.message ?: "An unexcepted error occurred")
                }
                is Resource.Loading -> {
                    _popularState.value = PopularListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getTopRatedMovies() {
        flow<Resource<TopRatedDto>> {
            try {
                emit(Resource.Loading<TopRatedDto>())
                emit(Resource.Success<TopRatedDto>(repository.getTopRatedMovies()))
            } catch (e: HttpException) {
                emit(
                    Resource.Error<TopRatedDto>(
                        e.localizedMessage ?: "An unexpected error occured"
                    )
                )
            } catch (e: IOException) {
                emit(Resource.Error<TopRatedDto>("Couldn't reach server check your internet connection"))
            }
        }.onEach { resource ->
            when (resource) {
                is Resource.Success -> {
                    _topRatedState.value = TopRatedListState(movies = resource.data)
                }
                is Resource.Error -> {
                    _topRatedState.value =
                        TopRatedListState(
                            error = resource.message ?: "An unexcepted error occurred"
                        )
                }
                is Resource.Loading -> {
                    _topRatedState.value = TopRatedListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}