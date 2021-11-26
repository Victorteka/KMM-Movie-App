package letsgodigital.africa.tmdbkmm.repository

import letsgodigital.africa.tmdbkmm.network.models.MovieApiResponse
import letsgodigital.africa.tmdbkmm.utils.Resource

interface TMDBRemoteData {

    suspend fun getMoviesFromApi(apiKey: String, page: Int = 1): MovieApiResponse
}