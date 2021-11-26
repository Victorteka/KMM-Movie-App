package letsgodigital.africa.tmdbkmm.android.ui.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import letsgodigital.africa.tmdbkmm.android.R
import letsgodigital.africa.tmdbkmm.android.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }
}