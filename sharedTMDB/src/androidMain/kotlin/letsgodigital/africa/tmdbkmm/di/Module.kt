package letsgodigital.africa.tmdbkmm.di

import letsgodigital.africa.tmdbkmm.domain.MainDispatcher
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platFormModule(): Module = module {
    single { MainDispatcher() }
}