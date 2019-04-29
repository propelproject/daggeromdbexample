package com.example.mii_reivin.daggeromdbexample.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.mii_reivin.daggeromdbexample.Adapter.MovieListAdapter
import com.example.mii_reivin.daggeromdbexample.Application.GetMoviesApplication
import com.example.mii_reivin.daggeromdbexample.Component.DaggerGetMoviesComponent
import com.example.mii_reivin.daggeromdbexample.Component.DaggerMainActivityComponent
import com.example.mii_reivin.daggeromdbexample.Component.GetMoviesComponent
import com.example.mii_reivin.daggeromdbexample.Component.MainActivityComponent
import com.example.mii_reivin.daggeromdbexample.Interface.GetMoviesApi
import com.example.mii_reivin.daggeromdbexample.Model.MovieList
import com.example.mii_reivin.daggeromdbexample.Module.ContextModule
import com.example.mii_reivin.daggeromdbexample.Module.MainActivityModule
import com.example.mii_reivin.daggeromdbexample.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var movieListAdapter: MovieListAdapter

    @Inject
    lateinit var getMoviesApi: GetMoviesApi

//    var picasso: Picasso? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        listMovies()
//        firstDaggerImplementation()

        secondDaggerImplementation()
    }
//        movieListAdapter = mainActivityComponent.getMovieListAdapter()

//    fun firstDaggerImplementation() {
//
//        var daggerGetMoviesComponent: GetMoviesComponent = DaggerGetMoviesComponent.builder()
//            .contextModule(ContextModule(this))
//            .build()
//        var picasso: Picasso = daggerGetMoviesComponent.getPicasso()
//        var getMoviesApi: GetMoviesApi = daggerGetMoviesComponent.getMovie()
//        getMoviesApi.getMovieList("bdbedf66", "avengers").enqueue(object : Callback<MovieList> {
//            override fun onFailure(call: Call<MovieList>, t: Throwable) {
//                Log.d("MoviesDagger", t.toString())
//            }
//
//            override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
//                var mov = response?.body()
//                var movItem = mov?.movieSearches
//                movItem?.forEach {
//                    Log.d("MoviesDagger", it.Title + " " + it.imdbID)
//                }
////                populateData(movItem, mov)
//            }
//        })
//
//    }

    fun secondDaggerImplementation() {
        var mainActivityComponent: MainActivityComponent = DaggerMainActivityComponent.builder()
            .mainActivityModule(MainActivityModule(this))
            .getMoviesComponent(GetMoviesApplication.get(this).getMoviesApplicationComponent)
            .build()

//        getMoviesApi = mainActivityComponent.getGetMovieApi()
        mainActivityComponent.injectMainActivity(this)

        Timber.plant(Timber.DebugTree())

        getMoviesApi.getMovieList("bdbedf66", "avengers").enqueue(object : Callback<MovieList> {
            override fun onFailure(call: Call<MovieList>, t: Throwable) {
                Log.d("MoviesDagger", t.toString())
            }

            override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                val mov = response.body()
                val movItem = mov?.movieSearches
                movItem?.forEach {
                    Timber.i(it.Title)
                }
                populateData(movItem, movieListAdapter)
            }
        })
    }

//    fun listMovies() {
//        val omdbServe : OmdbService =
//            createService()
//        val call = omdbServe.listMovies().enqueue(object : Callback<MovieList> {
//            override fun onFailure(call: Call<MovieList>, t: Throwable) {
//                Log.d("Movies", t.toString())
//            }
//
//            override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
//                var mov = response?.body()
//                var movItem = mov?.movieSearches
//                movItem?.forEach {
//                    Log.d("Movies", it.Title + " " + it.imdbID)
//                }
////                populateData(movItem)
//
//            }
//        })
//    }

    fun populateData(movieSearchList: List<com.example.mii_reivin.daggeromdbexample.Model.MovieSearch>?, movieListAdapter: MovieListAdapter) {
        Log.d("Movies", "populated")
        rvMovieList.layoutManager = LinearLayoutManager(this)
//        rvMovieList.adapter = MovieListAdapter(movieSearchList, this)
        movieListAdapter.setList(movieSearchList!!)
        rvMovieList.adapter = movieListAdapter
    }

//    companion object {
//        fun createService(): OmdbService {
//            val retrofit: Retrofit = Retrofit.Builder()
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .baseUrl("http://www.omdbapi.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//
//            return retrofit.create(OmdbService::class.java)
//        }
//    }
//
//    interface OmdbService {
//        @GET("?apikey=bdbedf66&s=avengers")
//        fun listMovies()
//                : Call<MovieList>
//
//    }

}
