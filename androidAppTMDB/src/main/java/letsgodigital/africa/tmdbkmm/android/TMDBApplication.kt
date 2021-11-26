package letsgodigital.africa.tmdbkmm.android

import android.app.Application
import letsgodigital.africa.tmdbkmm.android.di.viewModelModule
import letsgodigital.africa.tmdbkmm.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class TMDBApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidLogger()
            androidContext(this@TMDBApplication)
            modules(
                viewModelModule
            )
        }
    }
}