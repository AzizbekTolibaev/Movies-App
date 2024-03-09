package com.example.moviesapp.presentation.adapter.homefragmentadapter.movieadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.moviesapp.data.Movie
import com.example.moviesapp.data.MovieData
import com.example.moviesapp.databinding.ItemTopMovieBinding
import com.squareup.picasso.Picasso

class MovieAdapter: ListAdapter<Movie, MovieAdapter.TopMovieViewHolder>(myDiffUtil) {

    private var onClick: (movieId: Int) -> Unit = {}

    fun setOnItemClickListener(onClick: (movieId: Int) -> Unit) {
        this.onClick = onClick
    }

    inner class TopMovieViewHolder(private val binding: ItemTopMovieBinding): ViewHolder(binding.root) {
        fun bind(position: Int) {
            val d = getItem(position)
            Picasso.get().load("https://image.tmdb.org/t/p/w500" + d.posterPath).into(binding.imgMovie)

            binding.imgMovie.setOnClickListener {
                onClick.invoke(d.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopMovieViewHolder {
        return TopMovieViewHolder(
            ItemTopMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: TopMovieViewHolder, position: Int) {
       holder.bind(position)
    }

    private object myDiffUtil: DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }
}
