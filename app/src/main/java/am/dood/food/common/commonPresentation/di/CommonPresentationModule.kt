package am.dood.food.common.commonPresentation.di

import am.dood.food.common.commonPresentation.viewmodel.MainViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val commonPresentationModule = module {
    viewModelOf(::MainViewModel)
}