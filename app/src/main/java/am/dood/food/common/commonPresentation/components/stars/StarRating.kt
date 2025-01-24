package am.dood.food.common.commonPresentation.components.stars

import am.dood.food.R
import am.dood.food.common.commonPresentation.ui.theme.LightOrange
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun StarRating(
    modifier: Modifier = Modifier,
    rating: Float,
    maxStars: Int = 5,
) {
    val size = 16.dp
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        for (i in 1..maxStars) {
            when {
                i <= rating -> {
                    Icon(
                        modifier = Modifier.size(size),
                        painter = painterResource(id = R.drawable.ic_star_full),
                        contentDescription = null,
                        tint = LightOrange
                    )
                }

                i - 1 < rating && i > rating -> {
                    Icon(
                        modifier = Modifier.size(size),
                        painter = painterResource(id = R.drawable.ic_star_full),
                        contentDescription = null,
                        tint = LightOrange
                    )
                }

                else -> {
                    Icon(
                        modifier = Modifier.size(size),
                        painter = painterResource(id = R.drawable.ic_star_outlined),
                        contentDescription = null,
                        tint = LightOrange
                    )
                }
            }
        }
    }
}
