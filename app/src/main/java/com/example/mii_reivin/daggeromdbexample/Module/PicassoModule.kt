package com.example.mii_reivin.daggeromdbexample.Module

import android.content.Context
import com.example.mii_reivin.daggeromdbexample.Scope.GetMoviesApplicationScope
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Named

@Module(includes = arrayOf(OkHttpClientModule::class))
class PicassoModule {

    @GetMoviesApplicationScope
    @Provides
    fun picasso(@Named("application_context")context: Context, okHttp3Downloader: OkHttp3Downloader)
        : Picasso{
        return Picasso.Builder(context)
            .downloader(okHttp3Downloader)
            .build()
    }

    @Provides
    fun okHttp3Downloader(okHttpClient: OkHttpClient)
        : OkHttp3Downloader {
        return OkHttp3Downloader(okHttpClient)
    }

}