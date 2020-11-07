package com.example.tvmovieapp.movie

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        viewModel = MovieViewModel()
    }

    @Test
    fun getShow() {
        val movieEntites = viewModel.getShow()
        assertNotNull(movieEntites)
        assertEquals(11, movieEntites.size)
        val showTitleTest = movieEntites[4].title
        assertEquals("Cold Pursuit", showTitleTest)
        val directorTest = movieEntites[9].director
        assertEquals("Joe Russo & Anthony Russo", directorTest)
    }
}