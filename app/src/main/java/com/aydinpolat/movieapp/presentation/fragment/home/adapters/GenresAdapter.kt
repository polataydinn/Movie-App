package com.aydinpolat.movieapp.presentation.fragment.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aydinpolat.movieapp.data.remote.models.genre.Genre
import com.aydinpolat.movieapp.databinding.RowGenreItemBinding

class GenresAdapter : RecyclerView.Adapter<GenresViewHolder>() {
    private var listOfGenres = emptyList<Genre>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenresViewHolder {
        val binding = RowGenreItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GenresViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GenresViewHolder, position: Int) {
        holder.bind(listOfGenres[position])
    }

    override fun getItemCount() = listOfGenres.size

    fun setList(listOfGenres: List<Genre>){
        this.listOfGenres = listOfGenres
    }
}

class GenresViewHolder(private val binding: RowGenreItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(genre: Genre) {
        binding.genreText.text = genre.name
    }

}
