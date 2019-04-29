package com.example.mii_reivin.daggeromdbexample.Component

import com.example.mii_reivin.daggeromdbexample.Interface.GetMoviesApi
import com.example.mii_reivin.daggeromdbexample.Module.GetMoviesModule
import com.example.mii_reivin.daggeromdbexample.Module.PicassoModule
import com.example.mii_reivin.daggeromdbexample.Scope.GetMoviesApplicationScope
import com.squareup.picasso.Picasso
import dagger.Component
import retrofit2.http.Field
import javax.inject.Inject
import javax.inject.Singleton

@GetMoviesApplicationScope
@Component(modules = arrayOf(GetMoviesModule::class, PicassoModule::class))
interface GetMoviesComponent {

    fun getMovie(): GetMoviesApi
    fun getPicasso(): Picasso
}