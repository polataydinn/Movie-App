package com.aydinpolat.movieapp.data.remote.models.latest


import com.google.gson.annotations.SerializedName

data class LatestGenreDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)