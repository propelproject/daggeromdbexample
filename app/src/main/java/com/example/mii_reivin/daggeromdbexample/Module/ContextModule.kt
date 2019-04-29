package com.example.mii_reivin.daggeromdbexample.Module

import android.content.Context
import com.example.mii_reivin.daggeromdbexample.Scope.GetMoviesApplicationScope
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ContextModule {

    var context:Context

    constructor(context: Context) {
        this.context = context
    }

    @Named("application_context")
    @GetMoviesApplicationScope
    @Provides
    fun context(): Context {
        return context.applicationContext
    }
}