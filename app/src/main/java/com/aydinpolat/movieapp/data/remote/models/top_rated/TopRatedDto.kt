package com.aydinpolat.movieapp.data.remote.models.top_rated


import com.google.gson.annotations.SerializedName

data class TopRatedDto(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<TopRatedResultDto>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)