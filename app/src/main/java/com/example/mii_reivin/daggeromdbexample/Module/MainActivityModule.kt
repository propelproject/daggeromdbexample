package com.example.mii_reivin.daggeromdbexample.Module

import com.example.mii_reivin.daggeromdbexample.Adapter.MovieListAdapter
import com.example.mii_reivin.daggeromdbexample.Activity.MainActivity
import com.example.mii_reivin.daggeromdbexample.Model.MovieSearch
import com.example.mii_reivin.daggeromdbexample.Scope.MainActivityScope
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    var mainActivity: MainActivity

    constructor(mainActivity: MainActivity) {
        this.mainActivity = mainActivity
    }

    @Provides
    @MainActivityScope
    fun movieListAdapter(picasso: Picasso): MovieListAdapter {
        return MovieListAdapter(mainActivity, picasso)
    }

}