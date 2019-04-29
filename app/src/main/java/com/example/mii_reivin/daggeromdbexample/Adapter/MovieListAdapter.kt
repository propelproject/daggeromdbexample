package com.example.mii_reivin.daggeromdbexample.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mii_reivin.daggeromdbexample.Activity.MainActivity
import com.example.mii_reivin.daggeromdbexample.Model.MovieSearch
import com.example.mii_reivin.daggeromdbexample.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_list_card.view.*

class MovieListAdapter(val mainActivity: MainActivity, val picasso: Picasso) : RecyclerView.Adapter<MovieListAdapter.ViewHolder>(){

    var movieSearches: List<MovieSearch>? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.movie_list_card, p0, false))
    }

    override fun getItemCount(): Int {
        return movieSearches!!.size
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.tvMovieTitle.text = movieSearches?.get(p1)?.Title
        picasso.load(movieSearches?.get(p1)?.Poster).into(p0.ivMoviePoster)
    }

    fun setList(results: List<MovieSearch>) {
        movieSearches = results
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val tvMovieTitle = view.tvMovieTitle
        val ivMoviePoster = view.ivMoviePoster

    }

}