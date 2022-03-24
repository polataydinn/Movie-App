package com.aydinpolat.movieapp.data.remote.models.similar


import com.google.gson.annotations.SerializedName

data class SimilarDto(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<SimilarResultDto>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)