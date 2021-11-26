package letsgodigital.africa.tmdbkmm.android.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import letsgodigital.africa.tmdbkmm.android.R
import letsgodigital.africa.tmdbkmm.android.databinding.HomeFragmentBinding
import letsgodigital.africa.tmdbkmm.domain.TMDBRepository
import letsgodigital.africa.tmdbkmm.network.models.MovieDto
import letsgodigital.africa.tmdbkmm.utils.Resource
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {

    private val repository: TMDBRepository by inject()
    private lateinit var binding: HomeFragmentBinding
    private val viewModel by lazy {
        HomeViewModel(repository)
    }
    private lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        setupUI()
        setupObserver()
        return binding.root
    }

    private fun setupUI() {
        adapter = MovieAdapter(arrayListOf()){
            val action = HomeFragmentDirections.actionHomeFragmentToMovieDetailFragment(it.id)
            findNavController().navigate(action)
        }
        binding.recyclerView.adapter = adapter
    }

    private fun setupObserver() {
        viewModel.movies.observe(viewLifecycleOwner) { res ->
            when (res) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    res.data?.results?.let { it -> renderList(it) }
                }
                is Resource.Error -> {
                    binding.progressBar.visibility = View.GONE
                    binding.tvError.visibility = View.VISIBLE
                    binding.tvError.text = res.message
                }
            }

        }
    }

    private fun renderList(movies: List<MovieDto>) {
        adapter.addData(movies)
        adapter.notifyDataSetChanged()
    }

}