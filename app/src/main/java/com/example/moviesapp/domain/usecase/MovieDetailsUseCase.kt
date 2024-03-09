package com.example.moviesapp.domain.usecase

import com.example.moviesapp.data.Movie
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface MovieDetailsUseCase {
    suspend fun execute(movieId: Int): Flow<Response<Movie>>
}