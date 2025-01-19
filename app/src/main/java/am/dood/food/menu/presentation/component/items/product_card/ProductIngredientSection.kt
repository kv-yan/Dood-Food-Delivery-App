package am.dood.food.menu.presentation.component.items.product_card

import am.dood.food.R
import am.dood.food.menu.domain.model.product.ProductIngredient
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp


@Composable
fun ProductIngredientSection(modifier: Modifier = Modifier, ingredients: List<ProductIngredient>) {
    val scrollState = rememberScrollState()
    Text(modifier = Modifier.fillMaxWidth(), text = stringResource(R.string.ingredients), fontSize = 14.sp)
    Row(
        modifier = modifier.horizontalScroll(scrollState),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ingredients.forEach {
            ProductIngredientItem(productIngredient = it)
        }
    }
}
