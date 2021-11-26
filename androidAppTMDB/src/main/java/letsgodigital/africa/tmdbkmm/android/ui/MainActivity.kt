package letsgodigital.africa.tmdbkmm.android.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.StringDesc
import letsgodigital.africa.tmdbkmm.MR
import letsgodigital.africa.tmdbkmm.android.R
import letsgodigital.africa.tmdbkmm.android.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostContainer) as NavHostFragment
        navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.label == "movie_detail_fragment"){
                _binding.bottomNavigationView.visibility = View.GONE
            }else{
                _binding.bottomNavigationView.visibility = View.VISIBLE
            }
        }

        _binding.bottomNavigationView.setupWithNavController(navController)

    }
}
