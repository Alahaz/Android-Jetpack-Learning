package com.example.tvmovieapp.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tvmovieapp.R
import com.example.tvmovieapp.data.ShowEntity
import com.example.tvmovieapp.detail.DetailShowActivity
import kotlinx.android.synthetic.main.item_show.view.*

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ShowViewHolder>() {

    private var listShow = ArrayList<ShowEntity>()

    fun setShows(shows: List<ShowEntity>?) {
        if (shows == null) return
        listShow.clear()
        listShow.addAll(shows)
    }

    class ShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(show: ShowEntity) {
            with(itemView) {
                tv_item_title.text = show.title
                tv_item_genre.text = show.genre
                setOnClickListener {
                    val intent = Intent(context, DetailShowActivity::class.java).apply {
                        putExtra(DetailShowActivity.EXTRA_ID, show.showId)
                    }
                    context.startActivity(intent)
                }
                Glide.with(context)
                    .load(show.imagePath)
                    .into(img_poster)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_show, parent, false)
        return ShowViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) =
        holder.bind(listShow[position])

    override fun getItemCount(): Int = listShow.size
}