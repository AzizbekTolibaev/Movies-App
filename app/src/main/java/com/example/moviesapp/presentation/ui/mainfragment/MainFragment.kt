package com.example.moviesapp.presentation.ui.mainfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentMainBinding

class MainFragment: Fragment(R.layout.fragment_main) {
    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding get() = _binding!!
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

        setupBottomNavigationWithNavController()
    }

    private fun setupBottomNavigationWithNavController() {
        navController = (childFragmentManager.findFragmentById(R.id.fragment_container_main) as NavHostFragment).navController

        binding.bottomNavigation.setupWithNavController(navController)
    }
}
