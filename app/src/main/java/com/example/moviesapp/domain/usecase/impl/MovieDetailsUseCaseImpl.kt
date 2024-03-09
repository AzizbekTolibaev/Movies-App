package com.example.moviesapp.domain.usecase.impl

import com.example.moviesapp.domain.repository.MovieDetailsRepository
import com.example.moviesapp.domain.usecase.MovieDetailsUseCase

class MovieDetailsUseCaseImpl(private val repository: MovieDetailsRepository): MovieDetailsUseCase {
    override suspend fun execute(movieId: Int) = repository.getMovieDetails(movieId)
}