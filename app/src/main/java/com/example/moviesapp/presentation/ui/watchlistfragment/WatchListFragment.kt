package com.example.moviesapp.presentation.ui.watchlistfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentWatchListBinding

class WatchListFragment: Fragment(R.layout.fragment_watch_list) {
    private var _binding: FragmentWatchListBinding? = null
    private val binding: FragmentWatchListBinding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentWatchListBinding.bind(view)

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}
