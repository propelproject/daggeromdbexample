package com.example.mii_reivin.daggeromdbexample.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MovieList {

    @SerializedName("Search")
    @Expose
    var movieSearches: List<MovieSearch> = ArrayList()
}