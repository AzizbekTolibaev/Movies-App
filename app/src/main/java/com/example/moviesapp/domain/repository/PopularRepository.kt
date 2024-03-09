package com.example.moviesapp.domain.repository

import com.example.moviesapp.data.Movie
import com.example.moviesapp.data.MovieData
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface PopularRepository {

    suspend fun getPopularMovies(): Flow<Response<MovieData<Movie>>>
}