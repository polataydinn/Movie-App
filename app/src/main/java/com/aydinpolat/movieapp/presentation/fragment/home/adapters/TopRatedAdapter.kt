package com.aydinpolat.movieapp.presentation.fragment.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aydinpolat.movieapp.common.Constants
import com.aydinpolat.movieapp.data.remote.models.top_rated.TopRatedResultDto
import com.aydinpolat.movieapp.databinding.RowMovieCardBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class TopRatedAdapter : RecyclerView.Adapter<TopRatedViewHolder>() {

    private var topRatedMovieList = emptyList<TopRatedResultDto>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedViewHolder {
        val binding = RowMovieCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TopRatedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopRatedViewHolder, position: Int) {
        holder.bind(topRatedMovieList[position])
    }

    override fun getItemCount() = topRatedMovieList.size

    fun setList(topRatedMovieList: List<TopRatedResultDto>){
        this.topRatedMovieList = topRatedMovieList
    }
}

class TopRatedViewHolder(private val binding: RowMovieCardBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(topRatedMovie: TopRatedResultDto) {
        Glide.with(binding.posterImage)
            .load(Constants.IMAGE_BASE_URL + topRatedMovie.posterPath)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.posterImage)
    }

}
