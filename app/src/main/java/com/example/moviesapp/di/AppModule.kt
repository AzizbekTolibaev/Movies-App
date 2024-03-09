package com.example.moviesapp.di

import com.example.moviesapp.presentation.viewmodel.MovieDetailsViewModel
import com.example.moviesapp.presentation.viewmodel.NowPlayingViewModel
import com.example.moviesapp.presentation.viewmodel.PopularViewModel
import com.example.moviesapp.presentation.viewmodel.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        NowPlayingViewModel(useCase = get())
    }

    viewModel {
        PopularViewModel(useCase = get())
    }

    viewModel {
        SearchViewModel(useCase = get())
    }

    viewModel {
        MovieDetailsViewModel(useCase = get())
    }
}
