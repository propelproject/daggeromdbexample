package com.example.mii_reivin.daggeromdbexample.Interface

import com.example.mii_reivin.daggeromdbexample.Model.Movie
import com.example.mii_reivin.daggeromdbexample.Model.MovieList
import dagger.Component
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject

interface GetMoviesApi {

    @GET(".")
    fun getMovie(@Query("apikey") apikey: String, @Query("i") imdbId: String) : Call<Movie>

    @GET(".")
    fun getMovieList(@Query("apikey") apikey: String, @Query("s") searchQuery: String)
            : Call<MovieList>
}