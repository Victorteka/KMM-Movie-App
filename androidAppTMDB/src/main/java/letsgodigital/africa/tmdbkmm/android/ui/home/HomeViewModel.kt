package letsgodigital.africa.tmdbkmm.android.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import letsgodigital.africa.tmdbkmm.domain.TMDBRepository
import letsgodigital.africa.tmdbkmm.network.models.MovieApiResponse
import letsgodigital.africa.tmdbkmm.utils.Resource

class HomeViewModel(
    repository: TMDBRepository
) : ViewModel() {
    val movies: LiveData<Resource<MovieApiResponse>> =
        repository.getMovies("f3c7fa74b102b69eaa809aef8e0768c6")
            .asLiveData()
}