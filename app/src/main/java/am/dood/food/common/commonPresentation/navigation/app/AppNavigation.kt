package am.dood.food.common.commonPresentation.navigation.app

import am.dood.food.common.commonPresentation.components.animation.AnimatedLogoScreen
import am.dood.food.common.commonPresentation.navigation.auth.AuthNavigation
import am.dood.food.menu.presentation.MenuScreen
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    startDestination: AppNavDestination = AppNavDestination.Auth,
    onAppClose: () -> Unit = {},
    onChangeTheme: (isDarkTheme: Boolean) -> Unit = {},
) {
    Box(modifier = Modifier.fillMaxSize()) {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = modifier.fillMaxSize()
        ) {
            composable<AppNavDestination.Auth> {
                AnimatedLogoScreen(modifier = Modifier) {
                    AuthNavigation(
                        onChangeTheme = onChangeTheme,
                        navigateToMenu = {
                            navController.navigate(AppNavDestination.Menu)
                        }
                    )
                }
            }

            composable<AppNavDestination.Menu> {
                MenuScreen(
                    onChangeTheme = onChangeTheme,
                    onAppClose = onAppClose
                )
            }
        }
    }
}