package com.example.moviesapp.data

import com.google.gson.annotations.SerializedName

data class SearchData(
    val id: Int,
    val title: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("poster_path")
    val posterPath: String
)
