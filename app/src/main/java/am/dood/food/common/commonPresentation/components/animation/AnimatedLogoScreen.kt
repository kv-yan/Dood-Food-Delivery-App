package am.dood.food.common.commonPresentation.components.animation

import am.dood.food.R
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun AnimatedLogoScreen(modifier: Modifier = Modifier, appContent: @Composable () -> Unit = {}) {

    var startAnimation by remember { mutableStateOf(false) }
    val transition = updateTransition(targetState = startAnimation, label = "LogoTransition")

    val animationProgress by transition.animateFloat(
        transitionSpec = { tween(durationMillis = 1300, easing = FastOutSlowInEasing) },
        label = "AnimationProgress"
    ) { animated -> if (animated) 1f else 0f }

    val isHalfway = animationProgress >= 0.1f

    val horizontalMargin by transition.animateDp(
        transitionSpec = { tween(durationMillis = 1300, easing = FastOutSlowInEasing) },
        label = "HorizontalMargin"
    ) { animated -> if (animated) 32.dp else 82.dp }

    val verticalMargin by transition.animateDp(
        transitionSpec = { tween(durationMillis = 1300, easing = FastOutSlowInEasing) },
        label = "VerticalMargin"
    ) { animated -> if (animated) 64.dp else 258.dp }

    val logoWidth by transition.animateDp(
        transitionSpec = { tween(durationMillis = 1300, easing = FastOutSlowInEasing) },
        label = "LogoWidth"
    ) { animated -> if (animated) 119.dp else 211.dp }

    val logoHeight by transition.animateDp(
        transitionSpec = { tween(durationMillis = 1300, easing = FastOutSlowInEasing) },
        label = "LogoHeight"
    ) { animated -> if (animated) 71.dp else 126.dp }

    val backgroundColor: Color by transition.animateColor(
        transitionSpec = { tween(durationMillis = 800, easing = LinearEasing) },
        label = "BackgroundColor"
    ) { animated -> if (animated) Color.Transparent else Color(0xFFFD7646) }

    // Start Animation with Delay
    LaunchedEffect(Unit) {
        delay(350)
        startAnimation = true
    }

    // Preload Navigation Content
    var isContentLoaded by remember { mutableStateOf(false) }
    LaunchedEffect(isHalfway) {
        if (isHalfway) {
            isContentLoaded = true // Preload content when animation is halfway
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        if (isContentLoaded) {
            appContent() // Show navigation only when it's preloaded
        }

        // Animated Logo
        Box(
            modifier = Modifier
                .padding(start = horizontalMargin, top = verticalMargin)
                .size(width = logoWidth, height = logoHeight)
                .align(Alignment.TopStart),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = stringResource(R.string.app_name)
            )
        }
    }
}


@Preview
@Composable
private fun AnimatedLogoScreenPreview() {
    AnimatedLogoScreen()
}