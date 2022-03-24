package com.aydinpolat.movieapp.data.remote.models.up_coming


import com.google.gson.annotations.SerializedName

data class UpComingDatesDto(
    @SerializedName("maximum")
    val maximum: String,
    @SerializedName("minimum")
    val minimum: String
)