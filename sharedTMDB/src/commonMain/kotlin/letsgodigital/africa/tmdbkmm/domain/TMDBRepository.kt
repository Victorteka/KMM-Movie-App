package letsgodigital.africa.tmdbkmm.domain

import kotlinx.coroutines.flow.Flow
import letsgodigital.africa.tmdbkmm.domain.model.Movie
import letsgodigital.africa.tmdbkmm.network.models.MovieApiResponse
import letsgodigital.africa.tmdbkmm.network.models.MovieDto
import letsgodigital.africa.tmdbkmm.utils.Resource

interface TMDBRepository {
    fun getMovies(apiKey: String, page: Int = 1): Flow<Resource<MovieApiResponse>>
}