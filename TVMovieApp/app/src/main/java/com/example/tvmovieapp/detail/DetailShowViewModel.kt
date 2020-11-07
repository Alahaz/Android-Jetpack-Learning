package com.example.tvmovieapp.detail

import androidx.lifecycle.ViewModel
import com.example.tvmovieapp.data.ShowEntity
import com.example.tvmovieapp.utils.ShowDummy

class DetailShowViewModel : ViewModel() {

    private lateinit var showId: String

    fun setSelectedShow(showId: String) {
        this.showId = showId
    }

    fun getMovie(): ShowEntity {
        lateinit var movie: ShowEntity
        val movieEntities = ShowDummy.generateDummyMovie()
        for (movieEntity in movieEntities) {
            if (movieEntity.showId == showId) {
                movie = movieEntity
            }
        }
        return movie
    }

    fun getTvShow(): ShowEntity {
        lateinit var tvShow: ShowEntity
        val tvEntities = ShowDummy.generateDummyTv()
        for (tvEntity in tvEntities) {
            if (tvEntity.showId == showId) {
                tvShow = tvEntity
            }
        }
        return tvShow
    }

}