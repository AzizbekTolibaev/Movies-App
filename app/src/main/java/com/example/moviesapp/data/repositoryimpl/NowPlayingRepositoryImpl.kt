package com.example.moviesapp.data.repositoryimpl

import com.example.moviesapp.data.apiservice.TMDBApiService
import com.example.moviesapp.domain.repository.NowPlayingRepository
import com.example.moviesapp.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class NowPlayingRepositoryImpl(private val api: TMDBApiService): NowPlayingRepository {
    override suspend fun getNowPlayingMovies() = flow {
        val response = api.getNowPlayingMovies()
        emit(response)
    }.flowOn(Dispatchers.IO)
}
