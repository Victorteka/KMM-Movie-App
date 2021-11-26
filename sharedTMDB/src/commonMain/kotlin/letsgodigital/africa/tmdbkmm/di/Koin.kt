package letsgodigital.africa.tmdbkmm.di

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import kotlinx.coroutines.Dispatchers
import letsgodigital.africa.tmdbkmm.domain.TMDBRepository
import letsgodigital.africa.tmdbkmm.mapper.MovieMapper
import letsgodigital.africa.tmdbkmm.network.TMDBRemoteDataImpl
import letsgodigital.africa.tmdbkmm.repository.TMDBRemoteData
import letsgodigital.africa.tmdbkmm.repository.TMDBRepositoryImpl
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module


fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
//        appDeclaration()
        modules(
            repositoryModule,
            mapperModule,
            dispatcherModule,
            useCasesModule,
            platFormModule()
        )
    }

// IOS
fun initKoin() = initKoin {}

val repositoryModule = module {
    single<TMDBRepository> { TMDBRepositoryImpl(get(), get()) }
    single<TMDBRemoteData> { TMDBRemoteDataImpl(get(named("baseUrl")), get()) }

    single {
        HttpClient {
            install(JsonFeature) {
                val json = kotlinx.serialization.json.Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                }
                serializer = KotlinxSerializer(json)
            }
        }
    }

    single<String>(named("baseUrl")) { "https://api.themoviedb.org/" }
    single(named("apiKey")) { "f3c7fa74b102b69eaa809aef8e0768c6" }
}

val useCasesModule = module {
//    factory { GetMoviesUseCase(get(named("apiKey")), get()) }
}

val mapperModule = module {
    factory { MovieMapper() }
}

val dispatcherModule = module {
    factory { Dispatchers.Default }
}