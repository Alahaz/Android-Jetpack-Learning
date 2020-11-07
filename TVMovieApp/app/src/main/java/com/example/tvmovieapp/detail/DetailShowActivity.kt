package com.example.tvmovieapp.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.TransformationUtils.centerCrop
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.bumptech.glide.request.RequestOptions.option
import com.example.tvmovieapp.R
import com.example.tvmovieapp.data.ShowEntity
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.activity_detail_film.*

class DetailShowActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "extra_from_movie"
        const val EXTRA_FROM_TV = "extra_from_tv"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_film)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailShowViewModel::class.java]

        val extras = intent.extras
        extras?.let {
            var showId = extras.getString(EXTRA_ID)
            if (showId != null) {
                viewModel.setSelectedShow(showId)
                populateShow(viewModel.getMovie())
            } else {
                showId = extras.getString(EXTRA_FROM_TV)
                showId?.let { viewModel.setSelectedShow(it) }
                populateShow(viewModel.getTvShow())
            }
        }
    }

    private fun populateShow(show: ShowEntity) {
        tv_show_title.text = show.title
        tv_show_date.text = show.releaseDate
        tv_show_genre.text = show.genre
        tv_show_direct.text = show.director
        tv_show_desc.text = show.synopsis
        Glide.with(this)
            .load(show.imagePath)
            .transform(BlurTransformation(5,2),CenterCrop())
            .into(img_background)
        Glide.with(this)
            .load(show.imagePath)
            .into(image_poster_xl)
    }
}