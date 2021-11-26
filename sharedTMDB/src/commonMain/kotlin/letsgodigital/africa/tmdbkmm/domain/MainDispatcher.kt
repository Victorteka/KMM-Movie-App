package letsgodigital.africa.tmdbkmm.domain

import kotlinx.coroutines.CoroutineDispatcher

expect class MainDispatcher(){
    val dispatcher: CoroutineDispatcher
}