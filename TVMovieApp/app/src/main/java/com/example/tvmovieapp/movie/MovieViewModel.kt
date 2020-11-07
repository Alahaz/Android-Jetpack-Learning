package com.example.tvmovieapp.movie

import androidx.lifecycle.ViewModel
import com.example.tvmovieapp.data.ShowEntity
import com.example.tvmovieapp.utils.ShowDummy

class MovieViewModel : ViewModel() {
    fun getShow(): List<ShowEntity> = ShowDummy.generateDummyMovie()
}