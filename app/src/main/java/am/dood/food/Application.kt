package am.dood.food

import am.dood.food.common.commonPresentation.di.commonPresentationModule
import am.dood.food.menu.domain.di.menuDomainModule
import am.dood.food.menu.presentation.di.menuPresentationModule
import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@Application)
            modules(
                commonPresentationModule,
                menuPresentationModule,
                menuDomainModule,
            )
        }
    }
}