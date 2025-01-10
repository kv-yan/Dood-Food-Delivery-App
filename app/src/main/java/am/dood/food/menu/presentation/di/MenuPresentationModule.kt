package am.dood.food.menu.presentation.di

import am.dood.food.menu.presentation.MenuViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val menuPresentationModule = module {
    viewModelOf(::MenuViewModel)

}