package letsgodigital.africa.tmdbkmm.android.ui.moviedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import letsgodigital.africa.tmdbkmm.android.R
import letsgodigital.africa.tmdbkmm.android.databinding.MovieDetailFragmentBinding

class MovieDetailFragment : Fragment() {

    private val args: MovieDetailFragmentArgs by navArgs()
    private lateinit var binding: MovieDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MovieDetailFragmentBinding.inflate(inflater, container, false)
        Toast.makeText(context, args.movieId.toString(), Toast.LENGTH_LONG).show()
        return binding.root
    }
}