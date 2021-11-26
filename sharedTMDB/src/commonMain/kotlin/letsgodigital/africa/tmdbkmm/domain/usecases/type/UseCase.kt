package letsgodigital.africa.tmdbkmm.domain.usecases.type

import kotlinx.coroutines.flow.Flow

interface UseCase {

    fun execute(): Flow<Unit>

}