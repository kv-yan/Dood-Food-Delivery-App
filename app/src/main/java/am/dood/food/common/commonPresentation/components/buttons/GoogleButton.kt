package am.dood.food.common.commonPresentation.components.buttons

import am.dood.food.R
import am.dood.food.common.commonPresentation.ui.theme.MediumDimmedTextStyle
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun GoogleButton(
    modifier: Modifier = Modifier,
    onCLick: () -> Unit = {},
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(12.dp),
        onClick = onCLick
    ) {
        Row(
            modifier = modifier.padding(vertical = 12.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                16.dp,
                alignment = Alignment.CenterHorizontally
            )
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_google),
                contentDescription = stringResource(R.string.google)
            )

            Text(
                text = stringResource(R.string.sign_in_with_google),
                style = MediumDimmedTextStyle
            )
        }
    }
}