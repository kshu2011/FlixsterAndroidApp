package com.codepath.bestsellerlistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    private lateinit var titleTextView: TextView
    private lateinit var synopsisTextView: TextView
    private lateinit var posterImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_detail)

        titleTextView = findViewById(R.id.MovieTitleView)
        synopsisTextView = findViewById(R.id.MovieSynopsis)
        posterImageView = findViewById(R.id.MoviePoster)

        val movieTitle = intent.getStringExtra(MOVIE_TITLE)
        val movieSynopsis = intent.getStringExtra(MOVIE_SYNOPSIS)

        titleTextView.text = movieTitle
        synopsisTextView.text = movieSynopsis

        val posterPath = intent.getStringExtra(PATH)
        val thePath = "https://image.tmdb.org/t/p/w500/$posterPath"

        Glide.with(this)
            .load(thePath)
            .centerInside()
            .into(posterImageView)
    }
}