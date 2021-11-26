package letsgodigital.africa.tmdbkmm.domain.model


data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String,
    val backdropPath: String,
    val releaseDate: String
)
