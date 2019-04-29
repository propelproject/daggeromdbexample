package com.example.mii_reivin.daggeromdbexample.Application

import android.app.Activity
import android.app.Application
import com.example.mii_reivin.daggeromdbexample.Component.DaggerGetMoviesComponent
import com.example.mii_reivin.daggeromdbexample.Component.GetMoviesComponent
import com.example.mii_reivin.daggeromdbexample.Module.ContextModule
import timber.log.Timber

class GetMoviesApplication: Application() {

    var getMoviesApplicationComponent: GetMoviesComponent? = null

    companion object {
        fun get(activity: Activity): GetMoviesApplication {
            return activity.application as GetMoviesApplication
        }
    }


    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        getMoviesApplicationComponent = DaggerGetMoviesComponent.builder()
            .contextModule(ContextModule(this))
            .build()

    }

}