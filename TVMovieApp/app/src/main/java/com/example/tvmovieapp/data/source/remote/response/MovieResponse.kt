package com.example.tvmovieapp.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
    val id: Int,
    val title: String,
    val poster_path: String,
    val overview: String
) : Parcelable {
    val baseUrl: String get() = "https://image.tmdb.org/t/p/w500"
}