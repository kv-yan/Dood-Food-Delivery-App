package am.dood.food.menu.presentation.component.items

import am.dood.food.R
import am.dood.food.common.commonPresentation.components.image.Shadowed
import am.dood.food.common.commonPresentation.components.stars.StarRating
import am.dood.food.common.commonPresentation.ui.theme.LightOrange
import am.dood.food.menu.domain.model.Country
import am.dood.food.menu.domain.model.Product
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
fun ProductCard(
    modifier: Modifier = Modifier, product: Product, onClick: () -> Unit = {}
) {
    val productPainter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current).data(product.image).crossfade(true)
            .build()
    )
    Box(
        modifier = Modifier.padding(12.dp)
    ) {
        Card(
            modifier = modifier
                .align(Alignment.BottomCenter)
                .padding(top = 48.dp)
                .width(168.dp)
                .height(240.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            onClick = onClick
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                StarRating(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    rating = product.rating,
                    maxStars = 5,

                    )

                ProductCountrySection(
                    modifier = Modifier.fillMaxWidth(),
                    country = product.country,
                    productName = product.name
                )

                ProductPriceSection(
                    modifier = Modifier.fillMaxWidth(),
                    price = product.price.toFloat()
                )
            }
        }

        Shadowed(
            modifier = Modifier.size(172.dp),
            color = Color.Black.copy(alpha = 0.4f),
            offsetX = 4.dp,
            offsetY = 4.dp,
            blurRadius = 8.dp
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = productPainter,
                contentDescription = product.name,
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
private fun ProductCountrySection(
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

@Composable
fun ProductPriceSection(modifier: Modifier = Modifier, price: Float) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(start = 24.dp),
            text = "$ ${price.toInt()}",
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                fontWeight = FontWeight.W600,
                color = LightOrange,
            )
        )

        IconButton(
            modifier = Modifier.size(32.dp),
            onClick = { /*TODO*/ },
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = LightOrange,
                contentColor = Color.White,
            )
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = "Add to cart"
            )
        }
    }
}


@Preview
@Composable
private fun FoodAssortmentItemPreview() {
    ProductCard(
        product = Product(
            productId = 0,
            name = "Pizza Margarita",
            price = 10.0,
            image = "https://s3-alpha-sig.figma.com/img/3cbc/a5cf/d3466f4f3a121c9867c8de88159afd31?Expires=1736121600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=EJ2guOxJI9p5166pCTSsNXoffQHTlmGxnO9Mo7He19gFJbmAxsiE5MmXDuRBNx9GqUxAXWKhVphvBQoGQF0rLpnbDQHw73w75jEjhLVErt5ortSqN4c4E8BP2wycZjHGa6KpqnqqHszQXc9hD8ND~EEjKlgwG~3IfAQpVfBtZtAXpt2z4NrOq0SsFJr8MStjOU8t-oUkMm~d-zr-yUALBCvpkCe8YYnPqfrkLLLEF3RDKrUayl49Fc6VtWU7Ka4wNY-p3S1FYssg~WwQvrQfCMHSWYURiio9tR~hviBt8ld1IuMGaWSSqBQ965t4EdD7fz1P5q~5jWnzjpvzAz37rQ__",
            country = Country.ITALY,
        )
    )
}