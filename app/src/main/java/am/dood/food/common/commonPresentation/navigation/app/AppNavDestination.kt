package am.dood.food.common.commonPresentation.navigation.app

import kotlinx.serialization.Serializable

sealed class AppNavDestination {
    @Serializable
    data object Auth : AppNavDestination()

    @Serializable
    data object Menu : AppNavDestination()

    @Serializable
    data object Details : AppNavDestination()
}