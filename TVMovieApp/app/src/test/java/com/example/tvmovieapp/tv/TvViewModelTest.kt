package com.example.tvmovieapp.tv

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TvViewModelTest {

    private lateinit var viewModel: TvViewModel

    @Before
    fun setUp() {
        viewModel = TvViewModel()
    }

    @Test
    fun getShow() {
        val tvEntities = viewModel.getShow()
        assertNotNull(tvEntities)
        assertEquals(10, tvEntities.size)
        val releasedDateTest = tvEntities[5].releaseDate
        assertEquals("2014", releasedDateTest)
        val genreTest = tvEntities[9].genre
        assertEquals("Action, Adventure, & Drama", genreTest)

    }
}