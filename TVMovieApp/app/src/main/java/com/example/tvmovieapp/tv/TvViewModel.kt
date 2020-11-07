package com.example.tvmovieapp.tv

import androidx.lifecycle.ViewModel
import com.example.tvmovieapp.data.ShowEntity
import com.example.tvmovieapp.utils.ShowDummy

class TvViewModel : ViewModel() {
    fun getShow(): List<ShowEntity> = ShowDummy.generateDummyTv()
}