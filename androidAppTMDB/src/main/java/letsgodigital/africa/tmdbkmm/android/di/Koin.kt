package letsgodigital.africa.tmdbkmm.android.di

import letsgodigital.africa.tmdbkmm.android.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


/*val mapperModule = module {
    factory {  }
}*/

val viewModelModule = module {
    viewModel { HomeViewModel(get())  }
}