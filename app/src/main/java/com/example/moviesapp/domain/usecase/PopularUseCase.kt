package com.example.moviesapp.domain.usecase

import com.example.moviesapp.data.Movie
import com.example.moviesapp.data.MovieData
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface PopularUseCase {
    suspend fun execute(): Flow<Response<MovieData<Movie>>>
}