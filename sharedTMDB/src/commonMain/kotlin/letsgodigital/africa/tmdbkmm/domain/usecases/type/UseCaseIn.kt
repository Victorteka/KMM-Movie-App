package letsgodigital.africa.tmdbkmm.domain.usecases.type

import kotlinx.coroutines.flow.Flow

interface UseCaseIn <in IN>{

    fun execute(param: IN): Flow<Unit>
}