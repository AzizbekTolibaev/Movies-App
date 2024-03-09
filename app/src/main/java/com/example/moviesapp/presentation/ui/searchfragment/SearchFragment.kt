package com.example.moviesapp.presentation.ui.searchfragment

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentSearchBinding
import com.example.moviesapp.presentation.adapter.searchfragmentadapter.SearchAdapter
import com.example.moviesapp.presentation.ui.mainfragment.MainFragmentDirections
import com.example.moviesapp.presentation.viewmodel.SearchViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.isActive
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment(R.layout.fragment_search) {
    private var _binding: FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding get() = _binding!!
    private val adapter = SearchAdapter()
    private val viewModel by viewModel<SearchViewModel>()
    private var searchJob: Job? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSearchBinding.bind(view)

        binding.recyclerView.adapter = adapter



        setupObservers()
        setupListeners()

    }

    private fun setupListeners() {
        with(binding) {

            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }

            etSearch.addTextChangedListener { text ->
                lifecycleScope.launch {
                    searchJob?.cancel()
                    searchJob = lifecycleScope.launch {
                        delay(SEARCH_DELAY_MS)
                        shimmer.startShimmerAnimation()
                        shimmer.visibility = View.VISIBLE
                        recyclerView.visibility = View.GONE
                        layoutNoResult.visibility = View.GONE
                        if (text.toString().trim().isNotEmpty()) {
                            viewModel.getSearchMovies(text.toString().trim())
                        } else {
                            this.coroutineContext.job.cancel()
                            shimmer.stopShimmerAnimation()
                            shimmer.visibility = View.GONE
                            layoutNoResult.visibility = View.GONE
                            recyclerView.visibility = View.VISIBLE
                            adapter.submitList(listOf())
                        }
                    }
                }
            }

            adapter.setOnItemClickListener {
                val navHostFragment =
                    requireActivity().supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
                val navController = navHostFragment.findNavController()
                navController.navigate(MainFragmentDirections.actionMainFragmentToDetailFragment(it))
            }
        }
    }

    private fun setupObservers() {
        viewModel.successFlow.onEach {
            if (it.isNotEmpty()) {
                binding.shimmer.stopShimmerAnimation()
                binding.shimmer.visibility = View.GONE
                binding.layoutNoResult.visibility = View.GONE
                binding.recyclerView.visibility = View.VISIBLE
                adapter.submitList(it)
                if (it.isNotEmpty()) {
                    binding.recyclerView.scrollToPosition(0)
                }
            } else {
                binding.shimmer.stopShimmerAnimation()
                binding.shimmer.visibility = View.GONE
                binding.layoutNoResult.visibility = View.VISIBLE
                binding.recyclerView.visibility = View.GONE
                adapter.submitList(listOf())
            }
        }.launchIn(lifecycleScope)
    }

    companion object {
        private const val SEARCH_DELAY_MS = 200L
    }
}
