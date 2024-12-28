package am.dood.food.common.commonPresentation.navigation.app

import am.dood.food.R
import am.dood.food.common.commonPresentation.navigation.auth.AuthNavigation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier, startDestination: AppNavDestination = AppNavDestination.Auth
) {
    Box(modifier = Modifier.fillMaxSize()) {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = modifier.fillMaxSize()
        ) {
            composable<AppNavDestination.Auth> {
                AuthNavigation()
            }

            composable<AppNavDestination.Menu> {
                Text(
                    modifier = Modifier.fillMaxSize(),
                    text = "Menu",
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                    fontFamily = FontFamily(
                        Font(R.font.montserrat_semibold)
                    )
                )
            }

            composable<AppNavDestination.Details> {
                Text(
                    modifier = Modifier.fillMaxSize(),
                    text = "Details",
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                    fontFamily = FontFamily(
                        Font(R.font.montserrat_semibold)
                    )
                )
            }
        }
    }
}