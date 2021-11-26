package letsgodigital.africa.tmdbkmm.repository

import io.ktor.utils.io.errors.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import letsgodigital.africa.tmdbkmm.domain.TMDBRepository
import letsgodigital.africa.tmdbkmm.domain.model.Movie
import letsgodigital.africa.tmdbkmm.mapper.MovieMapper
import letsgodigital.africa.tmdbkmm.network.models.MovieApiResponse
import letsgodigital.africa.tmdbkmm.network.models.MovieDto
import letsgodigital.africa.tmdbkmm.utils.Resource

class TMDBRepositoryImpl(
    private val tmdbRemoteData: TMDBRemoteData,
    private val movieMapper: MovieMapper
) : TMDBRepository {
    override fun getMovies(apiKey: String, page: Int): Flow<Resource<MovieApiResponse>> = flow {
        try {
            emit(Resource.Loading())
            emit(Resource.Success(tmdbRemoteData.getMoviesFromApi(apiKey)))
        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server. Check internet connection!"))
        }catch (e: Exception){
            emit(Resource.Error(e.message?:"An error occurred! Try again"))
        }
    }
}