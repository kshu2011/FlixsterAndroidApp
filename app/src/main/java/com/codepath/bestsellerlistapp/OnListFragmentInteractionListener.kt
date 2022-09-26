package com.codepath.bestsellerlistapp

/**
 * This interface is used by the [TheMoviesRecyclerViewAdapter] to ensure
 * it has an appropriate Listener.
 *
 * In this app, it's implemented by [TheMoviesFragment]
 */
interface OnListFragmentInteractionListener {
    fun onItemClick(item: TheMovie)
}
