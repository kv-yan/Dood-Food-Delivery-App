package am.dood.food

import am.dood.food.ui.theme.DoodFoodTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DoodFoodTheme {
                AnimatedLogoScreen(modifier = Modifier)
            }
        }
    }
}
