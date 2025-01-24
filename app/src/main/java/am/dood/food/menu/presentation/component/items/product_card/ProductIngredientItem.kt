package am.dood.food.menu.presentation.component.items.product_card

import am.dood.food.common.commonPresentation.ui.theme.SoftGray
import am.dood.food.menu.domain.model.product.ProductIngredient
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ProductIngredientItem(modifier: Modifier = Modifier, productIngredient: ProductIngredient) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = modifier
                .clip(RoundedCornerShape(4.dp))
                .background(SoftGray)
                .padding(8.dp)
        ) {

            Image(
                modifier = modifier.size(24.dp),
                painter = painterResource(id = productIngredient.icon),
                contentDescription = productIngredient.name,
                contentScale = ContentScale.Crop
            )
        }

        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = productIngredient.name,
            fontSize = 12.sp
        )
    }
}
