package com.example.moviesapp.di

import com.example.moviesapp.domain.usecase.MovieDetailsUseCase
import com.example.moviesapp.domain.usecase.NowPlayingUseCase
import com.example.moviesapp.domain.usecase.PopularUseCase
import com.example.moviesapp.domain.usecase.SearchUseCase
import com.example.moviesapp.domain.usecase.impl.MovieDetailsUseCaseImpl
import com.example.moviesapp.domain.usecase.impl.NowPlayingUseCaseImpl
import com.example.moviesapp.domain.usecase.impl.PopularUseCaseImpl
import com.example.moviesapp.domain.usecase.impl.SearchUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory<NowPlayingUseCase> {
        NowPlayingUseCaseImpl(repository = get())
    }

    factory<PopularUseCase> {
        PopularUseCaseImpl(repository = get())
    }

    factory<SearchUseCase> {
        SearchUseCaseImpl(repository = get())
    }

    factory<MovieDetailsUseCase> {
        MovieDetailsUseCaseImpl(repository = get())
    }
}
