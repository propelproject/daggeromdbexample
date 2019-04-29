package com.example.mii_reivin.daggeromdbexample.Component

import com.example.mii_reivin.daggeromdbexample.Activity.MainActivity
import com.example.mii_reivin.daggeromdbexample.Adapter.MovieListAdapter
import com.example.mii_reivin.daggeromdbexample.Interface.GetMoviesApi
import com.example.mii_reivin.daggeromdbexample.Module.MainActivityModule
import com.example.mii_reivin.daggeromdbexample.Scope.MainActivityScope
import dagger.Component

@Component(modules = arrayOf(MainActivityModule::class), dependencies = arrayOf(GetMoviesComponent::class))
@MainActivityScope
interface MainActivityComponent {
//    fun getMovieListAdapter(): MovieListAdapter
//    fun getGetMovieApi(): GetMoviesApi

    fun injectMainActivity(mainActivity: MainActivity)
}