package com.aydinpolat.movieapp.presentation.fragment.home

import com.aydinpolat.movieapp.data.remote.models.genre.Genre
import com.aydinpolat.movieapp.data.remote.models.genre.GenresDto

data class GenreListState(
    val isLoading: Boolean? = false,
    val genres: GenresDto? = null,
    val error: String = ""
)
