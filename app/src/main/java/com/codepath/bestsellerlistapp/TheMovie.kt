package com.codepath.bestsellerlistapp

import com.google.gson.annotations.SerializedName

/**
 * The Model for storing a movie book from some movies API
 *
 * SerializedName tags MUST match the JSON response for the
 * object to correctly parse with the gson library.
 */
class TheMovie {
    @SerializedName("rank")
    var rank = 0

    @JvmField
    @SerializedName("title")
    var title: String? = null

    @JvmField
    @SerializedName("overview")
    var overview: String? = null

    //TODO bookImageUrl
    @SerializedName("poster_path")
    var poster_path: String? = null
}