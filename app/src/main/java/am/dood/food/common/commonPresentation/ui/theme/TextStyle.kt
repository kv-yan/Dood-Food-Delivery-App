package am.dood.food.common.commonPresentation.ui.theme

import am.dood.food.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

val TinyDimmedTextStyle = TextStyle(
    fontSize = 11.sp,
    fontFamily = FontFamily(Font(R.font.roboto_regular)),
    fontWeight = FontWeight.Normal,
    color = Color.Black.copy(alpha = 0.4f),
    textAlign = TextAlign.End,
)

val SmallTextStyle = TextStyle(
    fontSize = 13.sp,
    fontFamily = FontFamily(Font(R.font.roboto_regular)),
    fontWeight = FontWeight.Normal,
    color = Color.Black,
    textAlign = TextAlign.Center,
)

val DimmedTextStyle = TextStyle(
    fontSize = 13.sp,
    fontFamily = FontFamily(Font(R.font.roboto_regular)),
    fontWeight = FontWeight.Normal,
    color = Color.Black.copy(alpha = 0.4f),
    textAlign = TextAlign.Start,
)

val TitleTextStyle = TextStyle(
    fontSize = 14.sp,
    fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
    fontWeight = FontWeight.W600,
    color = DarkGray,
)

val PlaceholderTextStyle = TextStyle(
    fontSize = 14.sp,
    fontFamily = FontFamily(Font(R.font.roboto_regular)),
    fontWeight = FontWeight.Normal,
    color = TextFieldPlaceholderColor,
)

val MediumTextStyle = TextStyle(
    fontSize = 14.sp,
    fontFamily = FontFamily(Font(R.font.montserrat_medium)),
    fontWeight = FontWeight.W500,
    color = DarkGray,
)

val CenteredTextStyle = TextStyle(
    fontSize = 14.sp,
    fontFamily = FontFamily(Font(R.font.roboto_regular)),
    fontWeight = FontWeight.Normal,
    textAlign = TextAlign.Center,
)

val CaptionTextStyle = TextStyle(
    fontSize = 14.sp,
    lineHeight = 15.sp,
    fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
    fontWeight = FontWeight.W600,
    color = DarkSlate,
)

val MediumDimmedTextStyle = TextStyle(
    fontSize = 16.sp,
    fontFamily = FontFamily(Font(R.font.roboto_medium)),
    fontWeight = FontWeight.W500,
    color = Color.Black.copy(alpha = 0.54f),
)

val SubtitleTextStyle = TextStyle(
    fontSize = 18.sp,
    fontFamily = FontFamily(Font(R.font.roboto_medium)),
    fontWeight = FontWeight.W500,
    textAlign = TextAlign.Center,
)

val CenteredTitleTextStyle = TextStyle(
    fontSize = 18.sp,
    fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
    fontWeight = FontWeight.W600,
    color = DarkGray,
    textAlign = TextAlign.Center,
)

val AccentTextStyle = TextStyle(
    fontSize = 18.sp,
    fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
    fontWeight = FontWeight.W600,
    color = LightOrange,
)

val HighlightedTextStyle = TextStyle(
    fontSize = 24.sp,
    fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
    fontWeight = FontWeight(600),
    color = LightOrange,
)

val LargeTitleTextStyle = TextStyle(
    fontSize = 36.sp,
    fontFamily = FontFamily(Font(R.font.roboto_regular)),
    fontWeight = FontWeight.Normal,
    textAlign = TextAlign.Center,
)
