package com.aydinpolat.movieapp.data.remote.models.popular


import com.google.gson.annotations.SerializedName

data class PopularDto(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<PopularResultDto>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)