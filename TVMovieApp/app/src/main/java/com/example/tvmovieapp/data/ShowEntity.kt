package com.example.tvmovieapp.data

data class ShowEntity(
    var showId: String,
    var title: String,
    var genre: String,
    var director: String,
    var synopsis: String,
    var releaseDate: String,
    var imagePath: String
) {
}