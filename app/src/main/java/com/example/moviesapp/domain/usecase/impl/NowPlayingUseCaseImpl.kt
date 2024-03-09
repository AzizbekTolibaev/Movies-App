package com.example.moviesapp.domain.usecase.impl

import com.example.moviesapp.domain.repository.NowPlayingRepository
import com.example.moviesapp.domain.usecase.NowPlayingUseCase

class NowPlayingUseCaseImpl(private val repository: NowPlayingRepository): NowPlayingUseCase {
    override suspend fun execute() = repository.getNowPlayingMovies()
}
