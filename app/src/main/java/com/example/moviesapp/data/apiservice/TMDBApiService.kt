package com.example.moviesapp.data.apiservice

import com.example.moviesapp.data.Movie
import com.example.moviesapp.data.MovieData
import com.example.moviesapp.data.SearchData
import com.example.moviesapp.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TMDBApiService {

    @GET("/3/movie/now_playing?api_key=${Constants.API_KEY}&language=en-US&page=1")
    suspend fun getNowPlayingMovies(): Response<MovieData<Movie>>

    @GET("/3/movie/popular?api_key=${Constants.API_KEY}&language=en-US&page=1")
    suspend fun getPopularMovies(): Response<MovieData<Movie>>

    @GET("/3/search/movie?api_key=${Constants.API_KEY}&include_adult=false&language=en-US&page=1")
    suspend fun getSearchMovies(
        @Query("query") movieName: String
    ): Response<MovieData<SearchData>>

    @GET("/3/movie/{movie_id}?api_key=${Constants.API_KEY}&language=en-US")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int
    ): Response<Movie>
}
