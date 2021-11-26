package letsgodigital.africa.tmdbkmm.android.ui.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import letsgodigital.africa.tmdbkmm.android.R
import letsgodigital.africa.tmdbkmm.android.databinding.FavoritesFragmentBinding

class FavoritesFragment : Fragment(R.layout.favorites_fragment) {

    private lateinit var binding: FavoritesFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FavoritesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}