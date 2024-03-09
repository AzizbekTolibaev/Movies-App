package com.example.moviesapp.data

import com.google.gson.annotations.SerializedName

data class MovieData<T>(
    val page: Int,
    val results: List<T>
)

data class Movie(
    @SerializedName("id")
    val id: Int,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("runtime")
    val runtime: Int,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("overview")
    val overview: String
)
