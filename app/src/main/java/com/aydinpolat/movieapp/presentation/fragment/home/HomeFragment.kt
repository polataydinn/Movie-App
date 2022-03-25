package com.aydinpolat.movieapp.presentation.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.aydinpolat.movieapp.common.Constants
import com.aydinpolat.movieapp.data.remote.models.genre.Genre
import com.aydinpolat.movieapp.databinding.FragmentHomeBinding
import com.aydinpolat.movieapp.presentation.binding_adapter.BindingFragment
import com.aydinpolat.movieapp.presentation.fragment.home.adapters.GenresAdapter
import com.aydinpolat.movieapp.presentation.fragment.home.adapters.TopRatedAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BindingFragment<FragmentHomeBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentHomeBinding::inflate

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var topRatedAdapter: TopRatedAdapter
    private lateinit var popularAdapter: TopRatedAdapter
    private lateinit var genreAdapter: GenresAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getGenreList()
        getPopularMovies()
        getTopRatedMovies()
    }

    private fun getGenreList() {
        genreAdapter = GenresAdapter()
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.genreState.collect{
                if (it.genres != null){
                    genreAdapter.setList(it.genres.genres)
                    binding.genresRecyclerView.adapter = genreAdapter
                }
            }
        }
    }

    private fun getTopRatedMovies() {
        topRatedAdapter = TopRatedAdapter()
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.topRatedState.collect {
                if (it.movies != null) {
                    topRatedAdapter.setList(it.movies.results)
                    binding.homeTopRatedRecyclerView.adapter = topRatedAdapter
                }
            }
        }
    }

    private fun getPopularMovies() {
        popularAdapter = TopRatedAdapter()
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.popularState.collect {
                if (it.movies != null) {
                    popularAdapter.setList(it.movies.results)
                    binding.homePopularRecyclerView.adapter = popularAdapter
                }
            }
        }
    }
}