package com.codepath.bestsellerlistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    private lateinit var titleTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_detail)

        titleTextView = findViewById(R.id.MovieTitleView)

        val movieTitle = intent.getStringExtra(EXTRA_INFORMATION)

        titleTextView.text = movieTitle

    }
}