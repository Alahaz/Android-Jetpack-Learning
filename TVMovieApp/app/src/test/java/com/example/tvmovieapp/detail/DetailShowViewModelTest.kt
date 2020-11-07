package com.example.tvmovieapp.detail

import com.example.tvmovieapp.utils.ShowDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class DetailShowViewModelTest {
    private lateinit var viewModel: DetailShowViewModel
    private val dummyMovie = ShowDummy.generateDummyMovie()[0]
    private val dummyTv = ShowDummy.generateDummyTv()[0]
    private val movieId = dummyMovie.showId
    private val tvId = dummyTv.showId

    @Before
    fun setUp() {
        viewModel = DetailShowViewModel()
        viewModel.setSelectedShow(movieId)
        viewModel.setSelectedShow(tvId)
    }

    @Test
    fun getMovie() {
        viewModel.setSelectedShow(movieId)
        val movieEntity = viewModel.getMovie()
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.showId, movieEntity.showId)
        assertEquals(dummyMovie.imagePath, movieEntity.imagePath)
        assertEquals(dummyMovie.director, movieEntity.director)
        assertEquals(dummyMovie.releaseDate, movieEntity.releaseDate)
        assertEquals(dummyMovie.genre, movieEntity.genre)
    }

    @Test
    fun getTvShow() {
        viewModel.setSelectedShow(movieId)
        val tvShowEntity = viewModel.getTvShow()
        assertNotNull(tvShowEntity)
        assertEquals(dummyTv.showId, tvShowEntity.showId)
        assertEquals(dummyTv.imagePath, tvShowEntity.imagePath)
        assertEquals(dummyTv.director, tvShowEntity.director)
        assertEquals(dummyTv.releaseDate, tvShowEntity.releaseDate)
        assertEquals(dummyTv.genre, tvShowEntity.genre)
    }

}