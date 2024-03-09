package com.example.moviesapp.data.repositoryimpl

import com.example.moviesapp.data.apiservice.TMDBApiService
import com.example.moviesapp.domain.repository.MovieDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MovieDetailsRepositoryImpl(private val api: TMDBApiService): MovieDetailsRepository {

    override suspend fun getMovieDetails(movieId: Int) = flow {
        val response = api.getMovieDetails(movieId)
        emit(response)
    }.flowOn(Dispatchers.IO)
}
