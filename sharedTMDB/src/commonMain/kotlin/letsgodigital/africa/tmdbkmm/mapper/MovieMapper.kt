package letsgodigital.africa.tmdbkmm.mapper

import letsgodigital.africa.tmdbkmm.domain.model.Movie
import letsgodigital.africa.tmdbkmm.network.models.MovieDto
import letsgodigital.africa.tmdbkmm.utils.Mapper


class MovieMapper : Mapper<MovieDto, Movie>() {
    override fun map(model: MovieDto): Movie = model.run {
        Movie(
            id,
            title,
            overview,
            posterPath,
            backdropPath,
            releaseDate
        )
    }

    override fun inverseMap(model: Movie): MovieDto = model.run {
        MovieDto(
            id,
            title,
            overview,
            posterPath,
            backdropPath,
            releaseDate
        )
    }

}