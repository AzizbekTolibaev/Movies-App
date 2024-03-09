package com.example.moviesapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.moviesapp.data.Movie
import com.example.moviesapp.domain.usecase.MovieDetailsUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.catch

class MovieDetailsViewModel(private val useCase: MovieDetailsUseCase): ViewModel() {

    private val _successFlow = MutableSharedFlow<Movie>()
    val successFlow get() = _successFlow

    private val _messageFlow = MutableSharedFlow<String>()
    val messageFlow get() = _messageFlow

    private val _errorFlow = MutableSharedFlow<String>()
    val errorFlow get() = _errorFlow

    suspend fun getMovieDetails(movieId: Int) {
        useCase.execute(movieId)
            .catch {
                _errorFlow.emit(it.localizedMessage?:"Server menen baylanis joq")
            }
            .collect {
                if (it.isSuccessful) {
                    _successFlow.emit(it.body()!!)
                } else {
                    _messageFlow.emit(it.message())
                }
            }
    }
}
