package letsgodigital.africa.tmdbkmm.network

import io.ktor.client.*
import io.ktor.client.request.*
import letsgodigital.africa.tmdbkmm.network.models.MovieApiResponse
import letsgodigital.africa.tmdbkmm.repository.TMDBRemoteData
import letsgodigital.africa.tmdbkmm.utils.Resource

class TMDBRemoteDataImpl(
    private val baseUrl: String,
    private val httpClient: HttpClient
) : TMDBRemoteData {

    override suspend fun getMoviesFromApi(apiKey: String, page: Int): MovieApiResponse =
        httpClient.get {
            url("https://api.themoviedb.org/3/movie/popular?api_key=$apiKey&language=en-US&page=1")
        }
}