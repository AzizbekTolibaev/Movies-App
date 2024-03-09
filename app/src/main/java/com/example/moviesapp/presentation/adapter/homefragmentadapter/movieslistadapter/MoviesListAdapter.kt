package com.example.moviesapp.presentation.adapter.homefragmentadapter.movieslistadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.moviesapp.data.Movie
import com.example.moviesapp.data.MoviesListData
import com.example.moviesapp.databinding.ItemTopMoviesListBinding
import com.example.moviesapp.presentation.adapter.homefragmentadapter.movieadapter.MovieAdapter

class MoviesListAdapter: ListAdapter<MoviesListData, MoviesListAdapter.TopMoviesListViewHolder>(
    myDiffUtil
) {

    private var movie: (movieId: Int) -> Unit = {}

    fun setOnItemClickListener(movie: (movieId: Int) -> Unit) {
        this.movie = movie
    }

    inner class TopMoviesListViewHolder(private val binding: ItemTopMoviesListBinding): ViewHolder(binding.root) {
        fun bind(position: Int) {
            val d = getItem(position)

            val adapter = MovieAdapter()

            adapter.setOnItemClickListener {movieId ->
                movie.invoke(movieId)
            }

            binding.tvTitle.text = d.title
            binding.recyclerView.adapter = adapter
            adapter.submitList(d.data)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopMoviesListViewHolder {
        return TopMoviesListViewHolder(
            ItemTopMoviesListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: TopMoviesListViewHolder, position: Int) {
        holder.bind(position)
    }

    private object myDiffUtil: DiffUtil.ItemCallback<MoviesListData>() {
        override fun areItemsTheSame(oldItem: MoviesListData, newItem: MoviesListData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: MoviesListData, newItem: MoviesListData): Boolean {
            return oldItem == newItem
        }
    }
}
