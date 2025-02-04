package am.dood.food.common.commonPresentation.components.buttons

import am.dood.food.R
import am.dood.food.common.commonPresentation.ui.theme.LightOrange
import am.dood.food.common.commonPresentation.ui.theme.SubtitleTextStyle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp


@Composable
fun SolidButton(
    modifier: Modifier = Modifier,
    text: String = stringResource(R.string.empty_string),
    onClick: () -> Unit = {},
    content: @Composable (() -> Unit)? = null
) {

    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = LightOrange,
            contentColor = Color.White,
        ),
        shape = RoundedCornerShape(12.dp),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally)
        ) {
            content?.invoke()
            Text(
                modifier = Modifier
                    .padding(vertical = 16.dp),
                text = text, style = SubtitleTextStyle
            )
        }
    }
}
