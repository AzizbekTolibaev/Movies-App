package com.example.moviesapp.data.repositoryimpl

import com.example.moviesapp.data.apiservice.TMDBApiService
import com.example.moviesapp.domain.repository.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class SearchRepositoryImpl(private val api: TMDBApiService): SearchRepository {
    override suspend fun getSearchMovies(movieName: String) = flow {
        val response = api.getSearchMovies(movieName)
        emit(response)
    }.flowOn(Dispatchers.IO)
}