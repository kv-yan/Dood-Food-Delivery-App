package am.dood.food

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun AnimatedLogoScreen(modifier: Modifier = Modifier) {

    // State to trigger animation
    var startAnimation by remember { mutableStateOf(false) }

    // Transition for animating multiple properties
    val transition = updateTransition(targetState = startAnimation, label = "LogoTransition")

    // Animated Progress (0f to 1f)
    val animationProgress by transition.animateFloat(
        transitionSpec = { tween(durationMillis = 1500, easing = FastOutSlowInEasing) },
        label = "AnimationProgress"
    ) { animated ->
        if (animated) 1f else 0f
    }

    // Check if animation reached halfway
    val isHalfway = animationProgress >= 0.1f

    // Animated Margins for positioning
    val horizontalMargin by transition.animateDp(
        transitionSpec = { tween(durationMillis = 1500, easing = FastOutSlowInEasing) },
        label = "HorizontalMargin"
    ) { animated ->
        if (animated) 32.dp else 82.dp
    }

    val verticalMargin by transition.animateDp(
        transitionSpec = { tween(durationMillis = 1500, easing = FastOutSlowInEasing) },
        label = "VerticalMargin"
    ) { animated ->
        if (animated) 64.dp else 258.dp
    }

    // Animate Logo Size
    val logoWidth by transition.animateDp(
        transitionSpec = { tween(durationMillis = 1500, easing = FastOutSlowInEasing) },
        label = "LogoWidth"
    ) { animated ->
        if (animated) 119.dp else 211.dp
    }

    val logoHeight by transition.animateDp(
        transitionSpec = { tween(durationMillis = 1500, easing = FastOutSlowInEasing) },
        label = "LogoHeight"
    ) { animated ->
        if (animated) 71.dp else 126.dp
    }

    val backgroundColor by transition.animateColor(
        transitionSpec = { tween(durationMillis = 800, easing = LinearEasing) },
        label = "BackgroundColor"
    ) { animated ->
        if (animated) Color.Transparent else Color(0xFFFD7646)
    }

    // Start Animation with Delay
    LaunchedEffect(Unit) {
        delay(2000) // Delay for 2 seconds
        startAnimation = true
    }

    // Main Container
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        // Show Background Image at Halfway Point
        if (isHalfway) {
            Image(
                painter = painterResource(id = R.drawable.background_image),
                contentDescription = "Background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }

        // Animated Logo
        Box(
            modifier = Modifier
                .padding(
                    start = horizontalMargin, top = verticalMargin
                ) // Animate positioning
                .size(width = logoWidth, height = logoHeight)
                .align(Alignment.TopStart),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo"
            )
        }
    }
}


@Preview
@Composable
private fun AnimatedLogoScreenPreview() {
    AnimatedLogoScreen()
}