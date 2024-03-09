package com.example.moviesapp.presentation.ui.detailfragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentDetailBinding
import com.example.moviesapp.presentation.viewmodel.MovieDetailsViewModel
import com.example.moviesapp.utils.toast
import com.squareup.picasso.Picasso
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment: Fragment(R.layout.fragment_detail) {
    private var _binding: FragmentDetailBinding? = null
    private val binding: FragmentDetailBinding get() = _binding!!
    private val viewModel by viewModel<MovieDetailsViewModel>()
    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDetailBinding.bind(view)

        lifecycleScope.launch {
            viewModel.getMovieDetails(args.id)
        }

        setupObservers()
        setupListeners()
    }

    private fun setupListeners() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setupObservers() {
        with(binding) {

            viewModel.successFlow.onEach {
                tvTitle.text = it.originalTitle
                tvRuntime.text = "${it.runtime} minutes"
                tvOverviewAll.text = it.overview

                if (it.voteAverage.toString().length >= 3) {
                    tvVoteAverage.text = it.voteAverage.toString().substring(0, 3)
                } else {
                    tvVoteAverage.text = it.voteAverage.toString()
                }

                if (it.releaseDate.isNotEmpty()) {
                    tvReleaseDate.text = it.releaseDate.substring(0, 4)
                } else {
                    tvReleaseDate.text = "..."
                }
                Picasso.get().load("https://image.tmdb.org/t/p/w500" + it.backdropPath).into(imgBackgroundMovie)
                Picasso.get().load("https://image.tmdb.org/t/p/w500" + it.posterPath).into(imgMovie)
            }.launchIn(lifecycleScope)

            viewModel.messageFlow.onEach {
                toast("Message: $it")
            }.launchIn(lifecycleScope)

            viewModel.errorFlow.onEach {
                toast("Error: $it")
                Log.d("EEEE", "Error: $it")
            }.launchIn(lifecycleScope)
        }
    }
}
