package com.example.moviesapp.domain.repository

import com.example.moviesapp.data.MovieData
import com.example.moviesapp.data.SearchData
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface SearchRepository {

    suspend fun getSearchMovies(movieName: String): Flow<Response<MovieData<SearchData>>>
}