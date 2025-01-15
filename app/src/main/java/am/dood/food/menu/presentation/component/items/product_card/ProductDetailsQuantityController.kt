package am.dood.food.menu.presentation.component.items.product_card

import am.dood.food.R
import am.dood.food.common.commonPresentation.ui.theme.LightOrange
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val ComponentShape = RoundedCornerShape(8.dp)


@Composable
fun ProductDetailsQuantityController(
    modifier: Modifier = Modifier,
    quantity: Int,
    onQuantityChange: (Int) -> Unit = {}
) {
    Row(
        modifier = modifier
            .clip(ComponentShape)
            .background(Color(0xFFE0E0E0)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Card(
            shape = ComponentShape,
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFF3F3F3),
                contentColor = Color.Black
            ),
            onClick = { if (quantity > 1) onQuantityChange(quantity - 1) }

        ) {
            Box(modifier = Modifier.size(36.dp), contentAlignment = Alignment.Center) {
                Icon(
                    modifier = Modifier.size(12.dp),
                    painter = painterResource(id = R.drawable.ic_decrement),
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        }
        Text(
            text = quantity.toString(),
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 15.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                fontWeight = FontWeight(600),
                color = Color(0xFF24262F),
            )
        )

        Card(
            shape = ComponentShape,
            colors = CardDefaults.cardColors(
                containerColor = LightOrange,
            ),
            onClick = { onQuantityChange(quantity + 1) }
        ) {
            Box(modifier = Modifier.size(36.dp), contentAlignment = Alignment.Center) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        }
    }
}

@Preview
@Composable
private fun ProductDetailsQuantityControllerPrev() {
    var quantity by remember { mutableIntStateOf(1) }
    ProductDetailsQuantityController(quantity = quantity) {
        quantity = it

    }
}