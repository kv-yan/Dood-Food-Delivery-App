package am.dood.food.common.commonPresentation.navigation.auth

import kotlinx.serialization.Serializable

sealed class AuthNavDestination {
    @Serializable
    data object Login : AuthNavDestination()

    @Serializable
    data object Register : AuthNavDestination()

    @Serializable
    data object ForgotPassword : AuthNavDestination()

}