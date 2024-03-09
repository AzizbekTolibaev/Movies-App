package com.example.moviesapp.domain.usecase.impl

import com.example.moviesapp.domain.repository.SearchRepository
import com.example.moviesapp.domain.usecase.SearchUseCase

class SearchUseCaseImpl(private val repository: SearchRepository): SearchUseCase {
    override suspend fun execute(movieName: String) = repository.getSearchMovies(movieName)
}