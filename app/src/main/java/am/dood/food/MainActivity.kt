package am.dood.food

import am.dood.food.common.commonPresentation.navigation.app.AppNavigation
import am.dood.food.common.commonPresentation.ui.theme.ChangeSystemBarsTheme
import am.dood.food.common.commonPresentation.ui.theme.DoodFoodTheme
import am.dood.food.common.commonPresentation.viewmodel.MainViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val mainViewModel = koinViewModel<MainViewModel>()
            val isDarkTheme by mainViewModel.isDarkTheme.collectAsState(true)
            val onAppClose = { finish() }
            DoodFoodTheme {
                AppNavigation(onAppClose = onAppClose) {
                    mainViewModel.setDarkTheme(it)
                }
                ChangeSystemBarsTheme(isDarkTheme, this)
            }
        }
    }
}
