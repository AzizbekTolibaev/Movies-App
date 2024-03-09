package com.example.moviesapp.di

import com.example.moviesapp.data.repositoryimpl.MovieDetailsRepositoryImpl
import com.example.moviesapp.data.repositoryimpl.NowPlayingRepositoryImpl
import com.example.moviesapp.data.repositoryimpl.PopularRepositoryImpl
import com.example.moviesapp.data.repositoryimpl.SearchRepositoryImpl
import com.example.moviesapp.domain.repository.MovieDetailsRepository
import com.example.moviesapp.domain.repository.NowPlayingRepository
import com.example.moviesapp.domain.repository.PopularRepository
import com.example.moviesapp.domain.repository.SearchRepository
import org.koin.dsl.module

val dataModule = module {
    single<NowPlayingRepository> {
        NowPlayingRepositoryImpl(api = get())
    }

    single<PopularRepository> {
        PopularRepositoryImpl(api = get())
    }

    single<SearchRepository> {
        SearchRepositoryImpl(api = get())
    }

    single<MovieDetailsRepository> {
        MovieDetailsRepositoryImpl(api = get())
    }
}