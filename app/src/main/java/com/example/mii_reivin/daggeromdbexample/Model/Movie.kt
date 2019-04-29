package com.example.mii_reivin.daggeromdbexample.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Movie (
    @SerializedName("Title") @Expose val title: String,
    @SerializedName("Poster") @Expose val poster: String
)