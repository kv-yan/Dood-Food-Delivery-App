package am.dood.food.signUp.presentation.items

import am.dood.food.R
import am.dood.food.menu.domain.model.Country
import am.dood.food.menu.domain.model.Product
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Composable
fun FoodAssortmentItem(modifier: Modifier = Modifier, product: Product) {
    val productPainter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current).data(product.image).crossfade(true)
            .build()
    )
    Box(modifier = Modifier.padding(12.dp)) {
        Card(
            modifier = modifier
                .align(Alignment.BottomCenter)
                .padding(top = 48.dp)
                .width(168.dp)
                .height(280.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(modifier = Modifier.padding(12.dp)) {
                Row {
                    Image(
                        modifier = Modifier
                            .width(19.79487.dp)
                            .height(12.72528.dp),
                        painter = painterResource(id = product.country.icon),
                        contentDescription = product.country.type,
                    )

                    Text(
                        text = "Vegetable ",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFF1B1B1B),
                        )
                    )
                }
            }
        }
        Image(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .width(168.dp)
                .height(168.dp),
            painter = productPainter,
            contentDescription = product.name,
        )

    }
}

@Preview
@Composable
private fun FoodAssortmentItemPreview() {
    FoodAssortmentItem(
        product = Product(
            productId = 0,
            name = "Pizza Margarita",
            price = 10.0,
            image = "https://s3-alpha-sig.figma.com/img/3cbc/a5cf/d3466f4f3a121c9867c8de88159afd31?Expires=1736121600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=EJ2guOxJI9p5166pCTSsNXoffQHTlmGxnO9Mo7He19gFJbmAxsiE5MmXDuRBNx9GqUxAXWKhVphvBQoGQF0rLpnbDQHw73w75jEjhLVErt5ortSqN4c4E8BP2wycZjHGa6KpqnqqHszQXc9hD8ND~EEjKlgwG~3IfAQpVfBtZtAXpt2z4NrOq0SsFJr8MStjOU8t-oUkMm~d-zr-yUALBCvpkCe8YYnPqfrkLLLEF3RDKrUayl49Fc6VtWU7Ka4wNY-p3S1FYssg~WwQvrQfCMHSWYURiio9tR~hviBt8ld1IuMGaWSSqBQ965t4EdD7fz1P5q~5jWnzjpvzAz37rQ__",
            country = Country.ITALY
        )
    )
}