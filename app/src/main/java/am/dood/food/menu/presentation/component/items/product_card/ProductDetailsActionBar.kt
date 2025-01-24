package am.dood.food.menu.presentation.component.items.product_card

import am.dood.food.R
import am.dood.food.common.commonPresentation.ui.theme.CenteredTitleTextStyle
import am.dood.food.menu.domain.model.product.Product
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun ProductDetailsActionBar(
    modifier: Modifier = Modifier,
    isExpanded: MutableState<Boolean>,
    product: Product,
    onClick: (menuVisible: Boolean) -> Unit = {}
) {
    AnimatedVisibility(
        modifier = modifier,
        visible = isExpanded.value,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {
                    isExpanded.value = false
                    onClick(true)
                },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = stringResource(R.string.label_close),
                )
            }

            Text(
                text = product.name,
                style = CenteredTitleTextStyle,
            )

            Spacer(modifier = Modifier.size(34.dp))
        }
    }

}