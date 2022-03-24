package com.aydinpolat.movieapp.data.remote.models.up_coming


import com.google.gson.annotations.SerializedName

data class UpComingDto(
    @SerializedName("dates")
    val dates: UpComingDatesDto,
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<UpComingResultDto>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)