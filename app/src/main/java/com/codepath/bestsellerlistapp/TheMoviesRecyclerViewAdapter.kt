package com.codepath.bestsellerlistapp

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codepath.bestsellerlistapp.R.id

const val MOVIE_TITLE = "MOVIE_TITLE"
const val MOVIE_SYNOPSIS = "MOVIE_SYNOPSIS"
const val PATH = "PATH"

/**
 * [RecyclerView.Adapter] that can display a [TheMovie]
 */
class TheMoviesRecyclerViewAdapter (
    private val movies: List<TheMovie>
    )
    : RecyclerView.Adapter<TheMoviesRecyclerViewAdapter.MovieViewHolder>()
    {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_the_movie, parent, false)
        return MovieViewHolder(view)
    }

    /**
     * This inner class lets us refer to all the different View elements
     * (Yes, the same ones as in the XML layout files!)
     */
    inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView), View.OnClickListener {
        var mItem: TheMovie? = null
        val mMovieTitle: TextView = mView.findViewById<View>(id.movie_title) as TextView
        val mMovieOverview: TextView = mView.findViewById<View>(id.movie_overview) as TextView
        val mMoviePoster: ImageView = mView.findViewById<View>(id.movie_image) as ImageView

        init {
            mView.setOnClickListener(this)
        }

        override fun toString(): String {
            return mMovieTitle.toString() + " '" + mMovieOverview.text + "'"
        }

        override fun onClick(v: View?) {
            val curr_movie = movies[this.adapterPosition]
            Log.e("clicking",this.adapterPosition.toString())
            Log.e("clicking",curr_movie.title.toString())


            val intent = Intent(MainActivity.instance, DetailActivity::class.java)
            intent.putExtra(MOVIE_TITLE, curr_movie.title)
            intent.putExtra(MOVIE_SYNOPSIS, curr_movie.overview)
            intent.putExtra(PATH, curr_movie.poster_path)
            MainActivity.instance.startActivity(intent)

        }
    }

    /**
     * This lets us "bind" each Views in the ViewHolder to its' actual data!
     */
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val curr_movie = movies[position]

        holder.mItem = curr_movie
        holder.mMovieTitle.text = curr_movie.title
        holder.mMovieOverview.text = curr_movie.overview

        val the_path = "https://image.tmdb.org/t/p/w500/" + curr_movie.poster_path

        Glide.with(holder.mView)
            .load(the_path)
            .centerInside()
            .into(holder.mMoviePoster)

//        holder.mView.setOnClickListener {
//            holder.mItem?.let { book ->
//                mListener?.onItemClick(book)
//            }
//        }
    }

    /**
     * Remember: RecyclerView adapters require a getItemCount() method.
     */
    override fun getItemCount(): Int {
        return movies.size
    }
}