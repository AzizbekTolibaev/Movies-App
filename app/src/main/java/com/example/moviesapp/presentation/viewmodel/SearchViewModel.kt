package com.example.moviesapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.data.Movie
import com.example.moviesapp.data.SearchData
import com.example.moviesapp.domain.usecase.SearchUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class SearchViewModel(private val useCase: SearchUseCase): ViewModel() {

    private val _successFlow = MutableSharedFlow<List<SearchData>>()
    val successFlow get() = _successFlow

    private val _messageFlow = MutableSharedFlow<String>()
    val messageFlow get() = _messageFlow

    private val _errorFlow = MutableSharedFlow<String>()
    val errorFlow get() = _errorFlow


    suspend fun getSearchMovies(movieName: String) {
        viewModelScope.launch {
            useCase.execute(movieName)
                .catch {
                    it.printStackTrace()
                    _errorFlow.emit(it.localizedMessage ?: "Server menen baylanis joq")
                }
                .collect {
                    if (it.isSuccessful) {
                        _successFlow.emit(it.body()!!.results)
                    } else {
                        _messageFlow.emit(it.message())
                    }
                }
        }
    }
}
