package am.dood.food.menu.presentation.component.items

import am.dood.food.R
import am.dood.food.menu.domain.model.FoodAssortment
import am.dood.food.menu.presentation.component.FoodCountries
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AssortmentPagerItem(modifier: Modifier = Modifier, assortment: FoodAssortment) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .systemBarsPadding(),
    ) {

        Text(
            modifier = Modifier.padding(start = 24.dp, top = 38.dp, bottom = 26.dp),
            text = "What food do you want?",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                fontWeight = FontWeight.W600,
                color = Color(0xFF1B1B1B),
            )
        )

        FoodCountries(
            Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, top = 24.dp, bottom = 12.dp),
            listOf("All", "Georgia", "Armenia", "Russia", "Italy", "France")
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        ) {
            items(items = assortment.products, key = { it.productId }) {

                ProductCard(product = it)

            }
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, bottom = 12.dp),
            text = stringResource(R.string.recommendation),
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                fontWeight = FontWeight(600),
                color = Color(0xFF1B1B1B),
            )
        )

        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(items = assortment.products, key = { it.productId }) {

                ProductCard(product = it)

            }
        }
    }
}
