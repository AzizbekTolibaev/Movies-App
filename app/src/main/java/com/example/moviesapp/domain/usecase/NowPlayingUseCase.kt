package com.example.moviesapp.domain.usecase

import com.example.moviesapp.data.Movie
import com.example.moviesapp.data.MovieData
import com.example.moviesapp.data.ResultData
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface NowPlayingUseCase {

    suspend fun execute(): Flow<Response<MovieData<Movie>>>
}