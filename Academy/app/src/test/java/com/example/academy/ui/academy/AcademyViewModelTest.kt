package com.example.academy.ui.academy

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class AcademyViewModelTest {

    private lateinit var viewModel: AcademyViewModel

    @Before
    fun setUp() {
        viewModel = AcademyViewModel()
    }

    @Test
    fun getCourse() {
        val courseEntities = viewModel.getCourse()
        assertNotNull(courseEntities)
        assertEquals(5, courseEntities.size)
    }
}