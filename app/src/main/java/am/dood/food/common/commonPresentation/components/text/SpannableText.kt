@file:Suppress("DEPRECATION")

package am.dood.food.common.commonPresentation.components.text

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

@Composable
fun SpannableText(
    modifier: Modifier = Modifier,
    fullText: String,
    underlineText: String,
    color: Color = Color(0xFF000000),
    fontSize: Int = 13,
    fontFamily: FontFamily? = FontFamily.Default,
    fontWeight: FontWeight = FontWeight.Normal,
    textAlign: TextAlign = TextAlign.Center,
    onClick: (() -> Unit)? = null
) {
    val annotatedString = buildAnnotatedString {
        val startIndex = fullText.indexOf(underlineText)
        val endIndex = startIndex + underlineText.length

        // Default style for the whole text
        withStyle(
            style = SpanStyle(
                color = color,
                fontSize = fontSize.sp,
                fontFamily = fontFamily,
                fontWeight = fontWeight
            )
        ) {
            append(fullText)
        }

        // Add underline style for the specific text
        addStyle(
            style = SpanStyle(
                color = color,
                textDecoration = androidx.compose.ui.text.style.TextDecoration.Underline
            ),
            start = startIndex,
            end = endIndex
        )

        // Add a click annotation if onClick is provided
        if (onClick != null) {
            addStringAnnotation(
                tag = "clickable",
                annotation = underlineText,
                start = startIndex,
                end = endIndex
            )
        }
    }

    ClickableText(
        modifier = modifier,
        text = annotatedString,
        style = androidx.compose.ui.text.TextStyle(
            textAlign = textAlign,
            fontSize = fontSize.sp,
            fontFamily = fontFamily,
            fontWeight = fontWeight
        ),
        onClick = { offset ->
            annotatedString.getStringAnnotations(tag = "clickable", start = offset, end = offset)
                .firstOrNull()?.let {
                    onClick?.invoke()
                }
        }
    )
}
