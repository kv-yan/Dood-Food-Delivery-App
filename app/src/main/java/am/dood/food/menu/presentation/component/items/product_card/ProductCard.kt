package am.dood.food.menu.presentation.component.items.product_card

import am.dood.food.R
import am.dood.food.common.commonPresentation.components.buttons.SolidButton
import am.dood.food.common.commonPresentation.components.image.Shadowed
import am.dood.food.common.commonPresentation.components.stars.StarRating
import am.dood.food.menu.domain.model.Country
import am.dood.food.menu.domain.model.Product
import am.dood.food.menu.domain.model.ProductDetails
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    modifier: Modifier = Modifier,
    product: Product,
    isExpanded: MutableState<Boolean>,
    onAppClose: () -> Unit = {},
    onClick: (menuVisible: Boolean) -> Unit = {}
) {
    val systemUiController = rememberSystemUiController()
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    var productBackgroundImageHeight by remember { mutableIntStateOf(0) }

    val transition = updateTransition(targetState = isExpanded, label = "ProductCardTransition")

    val cardHeight by transition.animateDp(label = "CardHeight",
        transitionSpec = { tween(durationMillis = ENTER_ANIMATION_DURATION) }) { expanded ->
        if (expanded.value) screenHeight else 240.dp
    }
    val cardWidth by transition.animateDp(label = "CardWidth",
        transitionSpec = { tween(durationMillis = ENTER_ANIMATION_DURATION) }) { expanded ->
        if (expanded.value) screenWidth else 168.dp
    }
    val imagePaddingTop by transition.animateDp(label = "ImagePaddingTop",
        transitionSpec = { tween(durationMillis = if (isExpanded.value) ENTER_ANIMATION_DURATION else EXIT_ANIMATION_DURATION) }) { expanded ->
        if (expanded.value) 82.dp else 0.dp
    }
    val cardPaddingTop by transition.animateDp(label = "ImagePaddingTop",
        transitionSpec = { tween(durationMillis = if (isExpanded.value) ENTER_ANIMATION_DURATION else EXIT_ANIMATION_DURATION) }) { expanded ->
        if (expanded.value) 0.dp else 48.dp
    }
    val imageRotation by transition.animateFloat(label = "ImageRotation", transitionSpec = {
        if (isExpanded.value) {
            tween(
                durationMillis = if (isExpanded.value) ENTER_ANIMATION_DURATION else EXIT_ANIMATION_DURATION,
                easing = CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.3f) // Overshoot easing
            )
        } else {
            tween(
                durationMillis = if (isExpanded.value) ENTER_ANIMATION_DURATION else EXIT_ANIMATION_DURATION,
                easing = CubicBezierEasing(0.4f, 0.2f, 0.0f, 0.4f) // Overshoot easing
            )

        }
    }) { expanded ->
        if (expanded.value) 0f else 90f
    }
    val imageSize by transition.animateDp(label = "ImageSize", transitionSpec = {
        tween(
            durationMillis = if (isExpanded.value) ENTER_ANIMATION_DURATION
            else EXIT_ANIMATION_DURATION
        )
    }) { expanded ->
        if (expanded.value) 324.dp else 172.dp
    }


    SideEffect {
        systemUiController.setSystemBarsColor(if (isExpanded.value) Color(0xFFF3F3F3) else Color.Transparent)
        systemUiController.statusBarDarkContentEnabled = true
    }

    if (isExpanded.value) BackHandler {
        onClick(true)
        isExpanded.value = false
    }
    else {
        BackHandler {
            onAppClose()
        }
    }
    val scrollState = rememberScrollState()


    Box(
        modifier = Modifier
            .padding(if (isExpanded.value) 0.dp else 12.dp)
    ) {
        Card(modifier = modifier
            .align(Alignment.BottomCenter)
            .width(cardWidth)
            .padding(top = cardPaddingTop, bottom = 8.dp)
            .height(cardHeight),
            elevation = CardDefaults.cardElevation(defaultElevation = if (isExpanded.value) 0.dp else 8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            onClick = {
                isExpanded.value = !isExpanded.value
                onClick(!isExpanded.value)
            }) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .fillMaxSize()
                    .let {
                        if (isExpanded.value) it
                            .verticalScroll(scrollState)
                            .heightIn(
                                min = 260.dp, max = 1500.dp
                            ) else it
                    },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = if (isExpanded.value) Arrangement.Top else Arrangement.Bottom
            ) {
                // Convert px to dp
                val productBackgroundImageHeightDp =
                    with(LocalDensity.current) { productBackgroundImageHeight.toDp() }

                StarRating(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = if (isExpanded.value) productBackgroundImageHeightDp else 16.dp,
                            bottom = 16.dp
                        ),
                    rating = product.rating,
                    maxStars = 5,
                )

                if (isExpanded.value) ProductDetailsSection(
                    modifier = Modifier
                        .width(width = cardWidth)
                        .padding(bottom = 16.dp),
                    productDetails = product.productDetails
                )

                if (isExpanded.value) ProductIngredientSection(
                    modifier = Modifier
                        .width(width = cardWidth)
                        .padding(bottom = 16.dp),
                    ingredients = product.productIngredients
                )
                if (!isExpanded.value) ProductCountrySection(
                    modifier = Modifier.fillMaxWidth(),
                    country = product.country,
                    productName = product.name
                )
                if (!isExpanded.value) ProductPriceSection(
                    modifier = Modifier.fillMaxWidth(), price = product.price.toFloat()
                )

                if (isExpanded.value) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        var quantity by remember { mutableIntStateOf(1) }
                        ProductDetailsQuantityController(quantity = quantity) {
                            quantity = it
                        }

                        Text(
                            text = stringResource(R.string.product_price, quantity * product.price),
                            style = TextStyle(
                                fontSize = 24.sp,
                                fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                                fontWeight = FontWeight(600),
                                color = Color(0xFFFD7646),
                            )
                        )
                    }

                    SolidButton(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                        text = stringResource(R.string.order_now),
                        onClick = {}) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_bag),
                            contentDescription = "Cart",
                            tint = Color.White
                        )
                    }
                }
            }
        }

        if (isExpanded.value) Image(
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
        ProductDetailsActionBar(
            modifier = Modifier
                .width(cardWidth)
                .align(Alignment.TopCenter)
                .padding(top = 16.dp)
                .systemBarsPadding(),
            isExpanded = isExpanded,
            product = product
        ) {
            isExpanded.value = false
            onClick(true)
        }
    }
}


@Preview
@Composable
private fun FoodAssortmentItemPreview() {
    val isExpanded = remember { mutableStateOf(false) }
    ProductCard(
        isExpanded = isExpanded, product = Product(
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