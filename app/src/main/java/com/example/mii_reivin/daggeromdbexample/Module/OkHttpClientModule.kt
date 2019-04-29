package com.example.mii_reivin.daggeromdbexample.Module

import android.content.Context
import android.support.constraint.solver.Cache
import android.util.Log
import com.example.mii_reivin.daggeromdbexample.Scope.GetMoviesApplicationScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import javax.inject.Named

@Module(includes = arrayOf(ContextModule::class))
class OkHttpClientModule {

    @Provides
    fun okHttpClient(cache: okhttp3.Cache, httpLoggingInterceptor: HttpLoggingInterceptor)
    : OkHttpClient{
        return OkHttpClient()
            .newBuilder()
            .cache(cache)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    fun cache(cacheFile: File) : okhttp3.Cache {
        return okhttp3.Cache(cacheFile, 10 * 1000 * 1000)
    }

    @Provides
    @GetMoviesApplicationScope
    fun file(@Named("application_context") context: Context) : File {
        var file = File(context.cacheDir, "HttpCache")
        file.mkdirs()
        return file
    }

    @Provides
    fun httpLoggingInterceptor () : HttpLoggingInterceptor {
        var httpLoggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
            message -> Log.d("Movie", message)
        })
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return httpLoggingInterceptor
    }

}