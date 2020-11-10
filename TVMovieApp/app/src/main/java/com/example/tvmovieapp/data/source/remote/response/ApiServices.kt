package com.example.tvmovieapp.data.source.remote.response

import com.example.tvmovieapp.BuildConfig


interface ApiServices {
    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val API_KEY = BuildConfig.MOVIEDB_API_KEY
    }

    suspend fun getPopularMovies{
        @Query
    }
}