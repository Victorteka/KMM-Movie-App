package letsgodigital.africa.tmdbkmm.android.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import letsgodigital.africa.tmdbkmm.android.R
import letsgodigital.africa.tmdbkmm.android.databinding.MovieItemBinding
import letsgodigital.africa.tmdbkmm.network.models.MovieDto

class MovieAdapter(
    private val movies: ArrayList<MovieDto>,
    val onClickMovie: (MovieDto) -> Unit
) :
    RecyclerView.Adapter<MovieAdapter.MovieItemVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemVH = MovieItemVH(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.movie_item,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: MovieItemVH, position: Int) {
        holder.onBind(movies[position])
        holder.itemView.setOnClickListener { onClickMovie(movies[position]) }
    }

    override fun getItemCount() = movies.size

    fun addData(list: List<MovieDto>){
        movies.addAll(list)
    }

    inner class MovieItemVH(private val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(listItem: MovieDto) {
            binding.tvMovieTitle.text = listItem.title
            Glide.with(binding.ivMovie.context)
                .load("https://image.tmdb.org/t/p/w185/${listItem.posterPath}")
                .into(binding.ivMovie)
        }
    }
}