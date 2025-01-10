package am.dood.food.common.commonPresentation.components.image


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import kotlin.math.ceil

@Composable
fun Shadowed(
    modifier: Modifier = Modifier,
    color: Color,
    offsetX: Dp,
    offsetY: Dp,
    blurRadius: Dp,
    content: @Composable () -> Unit
) {
    val density = LocalDensity.current
    val offsetXPx = with(density) { offsetX.toPx() }.toInt()
    val offsetYPx = with(density) { offsetY.toPx() }.toInt()
    val blurRadiusPx = ceil(with(density) {
        blurRadius.toPx()
    }).toInt()

    // Modifier to render the content in the shadow color, then
    // blur it by blurRadius
    val shadowModifier = Modifier
        .drawWithContent {
            val matrix = shadowColorMatrix(color)
            val filter = ColorFilter.colorMatrix(matrix)
            val paint = Paint().apply {
                colorFilter = filter
            }
            drawIntoCanvas { canvas ->
                canvas.saveLayer(
                    Rect(
                        left = 0f,
                        top = 0f,
                        right = size.width,
                        bottom = size.height
                    ), paint
                )
                drawContent()
                canvas.restore()
            }
        }
        .blur(radius = blurRadius, BlurredEdgeTreatment.Unbounded)
        .padding(all = blurRadius) // Pad to prevent clipping blur

    // Layout based solely on the content, placing shadow behind it
    Layout(
        modifier = modifier,
        content = {
            // measurables[0] = content, measurables[1] = shadow
            content()
            Box(modifier = shadowModifier) { content() }
        }
    ) { measurables, constraints ->
        // Allow shadow to go beyond bounds without affecting layout
        val contentPlaceable = measurables[0].measure(constraints)
        val shadowPlaceable = measurables[1].measure(
            Constraints(
                maxWidth = contentPlaceable.width + blurRadiusPx * 2,
                maxHeight = contentPlaceable.height + blurRadiusPx * 2
            )
        )
        layout(width = contentPlaceable.width, height = contentPlaceable.height) {
            shadowPlaceable.placeRelative(
                x = offsetXPx - blurRadiusPx,
                y = offsetYPx - blurRadiusPx
            )
            contentPlaceable.placeRelative(x = 0, y = 0)
        }
    }
}

// Return a color matrix with which to paint our content
// as a shadow of the given color
private fun shadowColorMatrix(color: Color): ColorMatrix {
    return ColorMatrix().apply {
        set(row = 0, column = 0, v = 0f) // Do not preserve original R
        set(row = 1, column = 1, v = 0f) // Do not preserve original G
        set(row = 2, column = 2, v = 0f) // Do not preserve original B

        set(row = 0, column = 4, v = color.red * 255) // Use given color's R
        set(row = 1, column = 4, v = color.green * 255) // Use given color's G
        set(row = 2, column = 4, v = color.blue * 255) // Use given color's B
        set(row = 3, column = 3, v = color.alpha) // Multiply by given color's alpha
    }
}