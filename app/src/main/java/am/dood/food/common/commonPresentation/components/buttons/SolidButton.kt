package am.dood.food.common.commonPresentation.components.buttons

import am.dood.food.R
import am.dood.food.common.commonPresentation.ui.theme.PrimaryOrange
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SolidButton(
    modifier: Modifier = Modifier,
    text: String = stringResource(R.string.empty_string),
    onCLick: () -> Unit = {},
) {

    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = PrimaryOrange,
            contentColor = Color.White,
        ),
        shape = RoundedCornerShape(12.dp),
        onClick = onCLick
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            text = text, style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                fontWeight = FontWeight.W500,
                textAlign = TextAlign.Center,
            )
        )

    }
}
