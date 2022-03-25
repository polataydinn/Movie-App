package com.aydinpolat.movieapp.presentation.fragment.home

import com.aydinpolat.movieapp.data.remote.models.top_rated.TopRatedDto

data class PopularListState(
    val isLoading: Boolean? = false,
    val movies: TopRatedDto? = null,
    val error: String = ""
)