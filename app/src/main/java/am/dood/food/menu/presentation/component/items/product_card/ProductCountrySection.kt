package am.dood.food.menu.presentation.component.items.product_card

import am.dood.food.R
import am.dood.food.menu.domain.model.Country
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ProductCountrySection(
    modifier: Modifier = Modifier,
    country: Country,
    productName: String,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = 8.dp,
                end = 8.dp,
                bottom = 8.dp,
            )
    ) {
        Image(
            modifier = Modifier
                .width(20.dp)
                .height(14.dp),
            painter = painterResource(id = country.icon),
            contentDescription = country.type,
        )

        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = productName,
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                fontWeight = FontWeight.W600,
                color = Color(0xFF1B1B1B),
            ),
        )
    }
}