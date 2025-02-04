package am.dood.food.common.commonPresentation.ui.theme

import android.os.Build
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Purple80, secondary = PurpleGrey80, tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40, secondary = PurpleGrey40, tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun DoodFoodTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true, content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme, typography = Typography, content = content
    )
}

@Composable
fun ChangeSystemBarsTheme(lightTheme: Boolean, activity: ComponentActivity) {
    val barColor = MaterialTheme.colorScheme.background.toArgb()

    LaunchedEffect(lightTheme) {
        if (lightTheme) {
            activity.enableEdgeToEdge(
                statusBarStyle = SystemBarStyle.light(/* backgroundColor = */ Color.Transparent.toArgb(),/* darkIcons = */
                    darkScrim = barColor
                ),
                navigationBarStyle = SystemBarStyle.light(/* backgroundColor = */ Color.Transparent.toArgb(),/* darkIcons = */
                    darkScrim = barColor
                )
            )
        } else {
            activity.enableEdgeToEdge(
                statusBarStyle = SystemBarStyle.dark(
                    /* backgroundColor = */ Color.Transparent.toArgb(),
                    /* darkIcons = */
                ),
                navigationBarStyle = SystemBarStyle.dark(
                    /* backgroundColor = */ Color.Transparent.toArgb(),
                    /* darkIcons = */
                )
            )
        }
    }
}
