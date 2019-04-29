package com.example.mii_reivin.daggeromdbexample.Module

import android.content.Context
import com.example.mii_reivin.daggeromdbexample.Scope.GetMoviesApplicationScope
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ActivityModule {

    var context: Context

    constructor(context: Context) {
        this.context = context
    }

    @Named("activity_context")
    @GetMoviesApplicationScope
    @Provides
    fun context(): Context {
        return context
    }
}