package com.example.tvmovieapp.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.example.tvmovieapp.R
import com.example.tvmovieapp.utils.ShowDummy
import kotlinx.android.synthetic.main.fragment_movie.view.*
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

@Suppress("DEPRECATION")
class MainActivityTest{

    private val dummyMovie = ShowDummy.generateDummyMovie()
    private val dummyTv = ShowDummy.generateDummyTv()

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun loadMovie(){
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie(){
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,click()))
        onView(withId(R.id.tv_show_title)).check(matches(isDisplayed()))
        onView(withId(R.id.image_poster_xl)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_show_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_show_direct)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_show_genre)).check(matches(isDisplayed()))
    }

    @Test
    fun loadTvShow(){
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTv.size))
    }

    @Test
    fun loadDetailTvShow(){
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,click()))
        onView(withId(R.id.tv_show_title)).check(matches(isDisplayed()))
        onView(withId(R.id.image_poster_xl)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_show_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_show_direct)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_show_genre)).check(matches(isDisplayed()))
    }

}