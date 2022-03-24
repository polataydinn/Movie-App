package com.aydinpolat.movieapp.data.remote.models.genre


import com.google.gson.annotations.SerializedName

data class GenresDto(
    @SerializedName("genres")
    val genres: List<Genre>
)