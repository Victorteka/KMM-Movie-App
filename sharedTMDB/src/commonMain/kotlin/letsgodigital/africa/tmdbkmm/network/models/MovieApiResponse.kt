package letsgodigital.africa.tmdbkmm.network.models

import kotlinx.serialization.Serializable

@Serializable
data class MovieApiResponse(
    val page: Int,
    val results: List<MovieDto>
)
