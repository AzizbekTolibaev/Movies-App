package com.example.moviesapp.domain.usecase

import com.example.moviesapp.data.MovieData
import com.example.moviesapp.data.SearchData
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface SearchUseCase {

    suspend fun execute(movieName: String): Flow<Response<MovieData<SearchData>>>
}