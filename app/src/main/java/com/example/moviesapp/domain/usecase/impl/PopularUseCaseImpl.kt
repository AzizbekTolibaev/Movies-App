package com.example.moviesapp.domain.usecase.impl

import com.example.moviesapp.domain.repository.PopularRepository
import com.example.moviesapp.domain.usecase.PopularUseCase

class PopularUseCaseImpl(private val repository: PopularRepository): PopularUseCase {
    override suspend fun execute() = repository.getPopularMovies()
}