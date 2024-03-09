package com.example.moviesapp.data.repositoryimpl

import com.example.moviesapp.data.apiservice.TMDBApiService
import com.example.moviesapp.domain.repository.PopularRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PopularRepositoryImpl(private val api: TMDBApiService): PopularRepository {
    override suspend fun getPopularMovies() = flow {
        val response = api.getPopularMovies()
        emit(response)
    }.flowOn(Dispatchers.IO)
}