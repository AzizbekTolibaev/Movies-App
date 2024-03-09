package com.example.moviesapp.domain.repository

import com.example.moviesapp.data.Movie
import com.example.moviesapp.data.MovieData
import com.example.moviesapp.data.ResultData
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface NowPlayingRepository {

    suspend fun getNowPlayingMovies(): Flow<Response<MovieData<Movie>>>
}
