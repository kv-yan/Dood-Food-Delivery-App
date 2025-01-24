package am.dood.food.menu.presentation.component.items.product_card

import am.dood.food.R
import am.dood.food.menu.domain.model.product.ProductDetails
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ProductDetailsSection(modifier: Modifier = Modifier, productDetails: ProductDetails) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceEvenly) {
        ProductDetailsItem(
            title = productDetails.calories,
            image = R.drawable.ic_calories
        )

        ProductDetailsItem(
            title = productDetails.weight,
            image = R.drawable.ic_weight
        )

        ProductDetailsItem(
            title = productDetails.preparationTime,
            image = R.drawable.ic_clock
        )
    }
}
