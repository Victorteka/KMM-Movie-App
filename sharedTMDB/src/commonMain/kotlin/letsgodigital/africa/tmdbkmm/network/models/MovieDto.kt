package letsgodigital.africa.tmdbkmm.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDto(
    val id: Int,
    val title: String,
    val overview: String,
    @SerialName("poster_path")
    val posterPath: String,
    @SerialName("backdrop_path")
    val backdropPath: String,
    @SerialName("release_date")
    val releaseDate: String
)
