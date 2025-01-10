package am.dood.food.menu.presentation.component.items

import am.dood.food.R
import am.dood.food.common.commonPresentation.components.image.Shadowed
import am.dood.food.common.commonPresentation.components.stars.StarRating
import am.dood.food.common.commonPresentation.ui.theme.LightOrange
import am.dood.food.menu.domain.model.Country
import am.dood.food.menu.domain.model.Product
import am.dood.food.menu.domain.model.ProductDetails
import am.dood.food.menu.domain.model.ProductIngredient
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.google.accompanist.systemuicontroller.rememberSystemUiController

const val ENTER_ANIMATION_DURATION = 450
const val EXIT_ANIMATION_DURATION = 350


@Composable
fun ProductCard(
    modifier: Modifier = Modifier, product: Product, onClick: (menuVisible: Boolean) -> Unit = {}
) {
    val systemUiController = rememberSystemUiController()

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    var isExpanded by remember { mutableStateOf(false) }
    var productBackgroundImageHeight by remember { mutableIntStateOf(0) }

    val transition = updateTransition(targetState = isExpanded, label = "ProductCardTransition")

    val cardHeight by transition.animateDp(label = "CardHeight",
        transitionSpec = { tween(durationMillis = if (isExpanded) ENTER_ANIMATION_DURATION else EXIT_ANIMATION_DURATION) }) { expanded ->
        if (expanded) screenHeight else 240.dp
    }
    val cardWidth by transition.animateDp(label = "CardWidth",
        transitionSpec = { tween(durationMillis = if (isExpanded) ENTER_ANIMATION_DURATION else EXIT_ANIMATION_DURATION) }) { expanded ->
        if (expanded) screenWidth else 168.dp
    }
    val imagePaddingTop by transition.animateDp(label = "ImagePaddingTop",
        transitionSpec = { tween(durationMillis = if (isExpanded) ENTER_ANIMATION_DURATION else EXIT_ANIMATION_DURATION) }) { expanded ->
        if (expanded) 82.dp else 0.dp
    }
    val cardPaddingTop by transition.animateDp(label = "ImagePaddingTop",
        transitionSpec = { tween(durationMillis = if (isExpanded) ENTER_ANIMATION_DURATION else EXIT_ANIMATION_DURATION) }) { expanded ->
        if (expanded) 0.dp else 48.dp
    }
    val imageRotation by transition.animateFloat(
        label = "ImageRotation",
        transitionSpec = {
            if (isExpanded) { // Only animate when not expanded
                tween(
                    durationMillis = if (isExpanded) ENTER_ANIMATION_DURATION else EXIT_ANIMATION_DURATION,
                    easing = CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.3f) // Overshoot easing
                )
            } else {
                snap() // Immediately set the value without animation
            }
        }
    ) { expanded ->
        if (expanded) 0f else 90f
    }
    val imageSize by transition.animateDp(label = "ImageSize",
        transitionSpec = { tween(durationMillis = if (isExpanded) ENTER_ANIMATION_DURATION else EXIT_ANIMATION_DURATION) }) { expanded ->
        if (expanded) 324.dp else 172.dp
    }


    LaunchedEffect(isExpanded) {
        systemUiController.setSystemBarsColor(if (isExpanded) Color(0xFFF3F3F3) else Color.Transparent)
        systemUiController.statusBarDarkContentEnabled = true
    }

    Box(
        modifier = Modifier.padding(if (isExpanded) 0.dp else 12.dp)
    ) {
        Card(modifier = modifier
            .align(Alignment.BottomCenter)
            .width(cardWidth)
            .padding(top = cardPaddingTop)
            .height(cardHeight),
            elevation = CardDefaults.cardElevation(defaultElevation = if (isExpanded) 0.dp else 8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            onClick = {
                isExpanded = !isExpanded
                onClick(!isExpanded)
            }) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = if (isExpanded) Arrangement.Top else Arrangement.Bottom
            ) {
                // Convert px to dp
                val productBackgroundImageHeightDp =
                    with(LocalDensity.current) { productBackgroundImageHeight.toDp() }

                StarRating(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = if (isExpanded) productBackgroundImageHeightDp else 16.dp,
                            bottom = 16.dp
                        ),
                    rating = product.rating,
                    maxStars = 5,
                )

                if (isExpanded)
                    ProductDetailsSection(
                        modifier = Modifier
                            .width(width = cardWidth)
                            .padding(bottom = 16.dp),
                        productDetails = product.productDetails
                    )

                if (isExpanded)
                    ProductIngredientSection(
                        modifier = Modifier
                            .width(width = cardWidth)
                            .padding(bottom = 16.dp),
                        ingredients = product.productIngredients
                    )
                if (!isExpanded)
                    ProductCountrySection(
                        modifier = Modifier.fillMaxWidth(),
                        country = product.country,
                        productName = product.name
                    )
                if (!isExpanded)
                    ProductPriceSection(
                        modifier = Modifier.fillMaxWidth(), price = product.price.toFloat()
                    )
            }
        }

        if (isExpanded)
            Image(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .width(screenWidth)
                    .onGloballyPositioned { layoutCoordinates ->
                        productBackgroundImageHeight = layoutCoordinates.size.height
                    },
                painter = painterResource(id = R.drawable.ic_product_details_background),
                contentDescription = "Menu",
                contentScale = ContentScale.FillWidth
            )

        Shadowed(
            modifier = Modifier
                .padding(top = imagePaddingTop)
                .size(imageSize)
                .align(Alignment.TopCenter)
                .graphicsLayer(rotationZ = imageRotation),
            color = Color.Black.copy(alpha = 0.4f),
            offsetX = 4.dp,
            offsetY = 4.dp,
            blurRadius = 8.dp
        ) {
            Image(
                modifier = Modifier.fillMaxSize(), painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current).data(product.image)
                        .crossfade(true).build()
                ), contentDescription = product.name, contentScale = ContentScale.Crop
            )
        }

        // Action bar
        AnimatedVisibility(
            modifier = Modifier
                .width(cardWidth)
                .align(Alignment.TopCenter)
                .padding(top = 16.dp)
                .systemBarsPadding(), visible = isExpanded
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                        isExpanded = !isExpanded
                        onClick(!isExpanded)
                    },
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "Close",
                    )
                }

                Text(
                    text = product.name,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                        fontWeight = FontWeight.W600,
                        color = Color(0xFF1B1B1B),
                    ),
                )

                Spacer(modifier = Modifier.size(34.dp))
            }
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
            text = stringResource(R.string.product_price, price.toInt()),
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                fontWeight = FontWeight.W600,
                color = LightOrange,
            )
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
                contentDescription = "Add to cart"
            )
        }
    }
}

@Composable
fun ProductDetailsSection(modifier: Modifier = Modifier, productDetails: ProductDetails) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceEvenly) {

        ProductDetailsItem(title = productDetails.calories, image = R.drawable.ic_calories)
        ProductDetailsItem(title = productDetails.weight, image = R.drawable.ic_weight)
        ProductDetailsItem(title = productDetails.preparationTime, image = R.drawable.ic_clock)

    }
}

@Composable
fun ProductDetailsItem(modifier: Modifier = Modifier, title: String, image: Int) {

    Row {
        Image(
            modifier = modifier.size(16.dp),
            painter = painterResource(id = image),
            contentDescription = title
        )

        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = title,
            fontSize = 12.sp
        )
    }

}

@Composable
fun ProductIngredientItem(modifier: Modifier = Modifier, productIngredient: ProductIngredient) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = modifier
                .clip(RoundedCornerShape(4.dp))
                .background(Color(0xFFF2F2F2))
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


@Composable
fun ProductIngredientSection(modifier: Modifier = Modifier, ingredients: List<ProductIngredient>) {
    val scrollState = rememberScrollState()
    Text(modifier = Modifier.fillMaxWidth(), text = "Ingredients", fontSize = 14.sp)
    Row(
        modifier = modifier.horizontalScroll(scrollState),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ingredients.forEach {
            ProductIngredientItem(productIngredient = it)
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
            rating = 3.7f,
            productDetails = ProductDetails("", "", ""),
            productIngredients = emptyList()
        )
    )
}