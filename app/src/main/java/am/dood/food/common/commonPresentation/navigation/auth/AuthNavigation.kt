package am.dood.food.common.commonPresentation.navigation.auth

import am.dood.food.common.commonPresentation.ui.theme.AuthBackground
import am.dood.food.forgotPassword.presentation.ForgotPasswordScreen
import am.dood.food.signIn.presentation.SignInScreen
import am.dood.food.signUp.presentation.SignUpScreen
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AuthNavigation(
    modifier: Modifier = Modifier,
    startDestination: AuthNavDestination = AuthNavDestination.Login,
    navigateToMenu: () -> Unit = {},
    onChangeTheme: (isDarkTheme: Boolean) -> Unit = {},
) {
    LaunchedEffect(Unit) {
        onChangeTheme(false)
    }

    Box(Modifier.fillMaxSize()) {
        AuthBackground()

        val navController = rememberNavController()

        NavHost(
            navController = navController, startDestination = startDestination, modifier = modifier
        ) {
            composable<AuthNavDestination.Login> {
                SignInScreen(
                    onSignUpClick = {
                        navController.navigate(AuthNavDestination.Register)
                    },
                    onForgotPasswordClick = {
                        navController.navigate(AuthNavDestination.ForgotPassword)
                    },
                    navigateToMenu = navigateToMenu
                )
            }

            composable<AuthNavDestination.Register> {
                SignUpScreen(
                    onSignInClick = {
                        navController.navigateUp()
                    },
                    navigateToMenu = navigateToMenu
                )
            }

            composable<AuthNavDestination.ForgotPassword> {
                ForgotPasswordScreen()
            }
        }

    }
}