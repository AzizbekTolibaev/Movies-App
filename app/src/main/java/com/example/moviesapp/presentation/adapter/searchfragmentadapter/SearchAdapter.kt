package com.example.moviesapp.presentation.adapter.searchfragmentadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.moviesapp.R
import com.example.moviesapp.data.Movie
import com.example.moviesapp.data.SearchData
import com.example.moviesapp.databinding.ItemSearchBinding
import com.squareup.picasso.Picasso

class SearchAdapter: ListAdapter<SearchData, SearchAdapter.SearchViewHolder>(myDiffUtil) {

    private var movie: (movieId: Int) -> Unit = {}

    fun setOnItemClickListener(movie: (movieId: Int) -> Unit) {
        this.movie = movie
    }

    inner class SearchViewHolder(private val binding: ItemSearchBinding): ViewHolder(binding.root) {
        fun bind(position: Int) {
            val d = getItem(position)

            binding.tvTitle.text = d.title

            if (d.voteAverage.toString().length >= 3) {
                binding.tvVoteAverage.text = d.voteAverage.toString().substring(0, 3)
            } else {
                binding.tvVoteAverage.text = d.voteAverage.toString()
            }

            if (d.releaseDate.isNotEmpty()) {
                binding.tvReleaseDate.text = d.releaseDate.substring(0, 4)
            } else {
                binding.tvReleaseDate.text = "..."
            }
            if (d.posterPath != null) {
                Picasso.get().load("https://image.tmdb.org/t/p/w500" + d.posterPath).into(binding.imgMovie)
            }

            binding.btnItem.setOnClickListener {
                movie.invoke(d.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(
            ItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(position)
    }

    private object myDiffUtil: DiffUtil.ItemCallback<SearchData>() {
        override fun areItemsTheSame(oldItem: SearchData, newItem: SearchData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: SearchData, newItem: SearchData): Boolean {
            return oldItem.id == newItem.id
        }
    }
}
