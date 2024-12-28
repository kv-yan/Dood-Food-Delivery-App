package am.dood.food.common.commonPresentation.navigation.auth

import am.dood.food.R
import am.dood.food.common.commonPresentation.ui.theme.AuthBackground
import am.dood.food.signIn.presentation.SignInScreen
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AuthNavigation(
    modifier: Modifier = Modifier, startDestination: AuthNavDestination = AuthNavDestination.Login
) {
    Box(Modifier.fillMaxSize()) {
        AuthBackground()

        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = modifier
        ) {
            composable<AuthNavDestination.Login> {
                SignInScreen()
            }

            composable<AuthNavDestination.Register> {
                Text(
                    modifier = Modifier.fillMaxSize(),
                    text = stringResource(R.string.register),
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                    fontFamily = FontFamily(
                        Font(R.font.montserrat_semibold)
                    )
                )
            }

            composable<AuthNavDestination.ForgotPassword> {
                Text(
                    modifier = Modifier.fillMaxSize(),
                    text = stringResource(R.string.forgot_password),
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