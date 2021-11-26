package letsgodigital.africa.tmdbkmm.domain.usecases.type

import kotlinx.coroutines.flow.Flow

interface UseCaseOut<out OUT> {

    fun execute(): Flow<OUT>
}