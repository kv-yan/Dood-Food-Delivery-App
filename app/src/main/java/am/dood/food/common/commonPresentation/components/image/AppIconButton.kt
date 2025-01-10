package am.dood.food.common.commonPresentation.components.image

import am.dood.food.common.commonPresentation.ui.theme.DarkOrange
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun AppIconButton(
    modifier: Modifier = Modifier,
    icon: Int,
    buttonColor: Color = DarkOrange,
    onClick: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center,
    ) {
        Surface(
            modifier = Modifier.size(34.dp),
            color = buttonColor,
            shape = RoundedCornerShape(10.dp),
        ) {}

        Icon(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = Color.White
        )

    }
}

@Composable
fun AppImageButton(
    modifier: Modifier = Modifier,
    icon: Int,
    onClick: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center,
    ) {
        Surface(
            modifier = Modifier.size(width = 28.dp, height = 30.dp),
            color = DarkOrange,
            shape = RoundedCornerShape(10.dp)
        ) {}

        Image(
            modifier = Modifier
                .size(38.dp)
                .align(Alignment.Center),
            painter = painterResource(id = icon),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

    }
}