package am.dood.food.menu.presentation.component.items.product_card

import am.dood.food.R
import am.dood.food.common.commonPresentation.ui.theme.AccentTextStyle
import am.dood.food.common.commonPresentation.ui.theme.LightOrange
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp


@Composable
fun ProductPriceSection(modifier: Modifier = Modifier, price: Float) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(start = 24.dp),
            text = stringResource(R.string.product_price, price.toInt()),
            style = AccentTextStyle
        )

        IconButton(
            modifier = Modifier.size(32.dp),
            onClick = {},
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = LightOrange,
                contentColor = Color.White,
            )
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = stringResource(R.string.label_add_to_cart)
            )
        }
    }
}
