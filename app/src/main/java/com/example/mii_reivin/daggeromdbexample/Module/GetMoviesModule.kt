package com.example.mii_reivin.daggeromdbexample.Module

import com.example.mii_reivin.daggeromdbexample.Config.Config
import com.example.mii_reivin.daggeromdbexample.Interface.GetMoviesApi
import com.example.mii_reivin.daggeromdbexample.Scope.GetMoviesApplicationScope
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Inject

@Module(includes = arrayOf(OkHttpClientModule::class))
class GetMoviesModule{

    @Provides
    fun getMoviesApi(retrofit: Retrofit) : GetMoviesApi{
        return retrofit.create(GetMoviesApi::class.java)
    }

    @GetMoviesApplicationScope
    @Provides
    fun retrofit(okHttpClient: OkHttpClient,
                 baseUrl: String,
                 gsonConverterFactory: GsonConverterFactory,
                 gson: Gson): Retrofit{
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(baseUrl)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    fun baseUrl(): String {
        var baseUrl = "http://www.omdbapi.com/"
        return baseUrl
    }

    @Provides
    fun gson(): Gson {
        var gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }

    @Provides
    fun gsonConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

}