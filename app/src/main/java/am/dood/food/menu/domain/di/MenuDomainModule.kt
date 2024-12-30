package am.dood.food.menu.domain.di

import am.dood.food.menu.domain.usaCase.GetAssortmentsUseCase
import am.dood.food.menu.domain.usaCase.GetAssortmentsUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val menuDomainModule = module {
    factoryOf(::GetAssortmentsUseCaseImpl) { bind<GetAssortmentsUseCase>() }
}
