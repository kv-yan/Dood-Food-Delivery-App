@file:OptIn(ExperimentalFoundationApi::class)

package am.dood.food.menu.presentation

import am.dood.food.R
import am.dood.food.common.commonPresentation.components.image.AppIconButton
import am.dood.food.common.commonPresentation.components.image.AppImageButton
import am.dood.food.common.commonPresentation.components.image.Shadowed
import am.dood.food.common.commonPresentation.ui.theme.LightOrange
import am.dood.food.menu.domain.model.FoodAssortment
import am.dood.food.menu.presentation.component.items.ProductCard
import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.compose.ui.zIndex
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

@Composable
fun MenuScreen(
    modifier: Modifier = Modifier,
    viewModel: MenuViewModel = koinViewModel(),
    onChangeTheme: (isDarkTheme: Boolean) -> Unit = {},
) {
    val context = LocalContext.current
    val screenState by viewModel.screenState.collectAsState()

    LaunchedEffect(Unit) {
        onChangeTheme(true)
    }

    when (val state = screenState) {
        is MenuScreenState.Error -> {
            Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
        }

        MenuScreenState.Loading -> {
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                CircularProgressIndicator(
                    strokeWidth = 4.dp,
                    color = LightOrange,
                )
            }
        }

        is MenuScreenState.Success -> {
            MenuContent(
                modifier = modifier,
                viewModel = viewModel,
            )
        }
    }

}

@Composable
private fun MenuContent(
    modifier: Modifier = Modifier,
    viewModel: MenuViewModel,
) {
    val isShowingScreen by viewModel.isShowingScreen.collectAsState()
    val screensState by viewModel.screenState.collectAsState()
    val screenSuccessState = screensState as? MenuScreenState.Success
    val assortment = screenSuccessState?.assortment ?: emptyList()


    LaunchedEffect(Unit) {
        delay(200)
        viewModel.setShowingScreen(true)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Row(modifier = modifier.fillMaxSize()) {

            LeftMenu(assortment, isShowingScreen)

            // Second AnimatedVisibility (Right to Left)
            AnimatedVisibility(
                modifier = Modifier.weight(1f),
                visible = isShowingScreen,
                enter = slideInHorizontally(
                    initialOffsetX = { it }, animationSpec = tween(durationMillis = 700)
                )
            ) {
                FoodDisplayingSection(viewModel = viewModel)
            }
        }

        AppIconButton(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .systemBarsPadding()
                .padding(
                    top = 24.dp, end = 8.dp
                ), icon = R.drawable.ic_bag, buttonColor = LightOrange
        )

    }
}

@SuppressLint("UseOfNonLambdaOffsetOverload")
@Composable
private fun LeftMenu(assortment: List<FoodAssortment>, isShowingMenu: Boolean) {
    var selectedIndex by remember { mutableIntStateOf(0) }

    AnimatedVisibility(
        modifier = Modifier
            .zIndex(1000f)
            .fillMaxHeight()
            .width(52.dp),
        visible = isShowingMenu,
        enter = slideInHorizontally(
            initialOffsetX = { -it }, animationSpec = tween(durationMillis = 500)
        ),
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            // Calculate offset dynamically
            val itemHeight = 86.dp // 24 (top) + 38 (content) + 24 (bottom)
            val startOffset =
                24.dp + (34.dp / 2) + (itemHeight * 2) // Start after the first two items

            // Animate highlight offset
            val highlightOffset by animateDpAsState(
                targetValue = startOffset + (selectedIndex * itemHeight),
                animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing),
                label = "HighlightOffsetAnimation"
            )

            // Highlight Shape
            Box(
                modifier = Modifier
                    .width(72.dp)
                    .offset(
                        y = highlightOffset,
                        x = 40.dp,
                    )
                    .align(Alignment.TopCenter),
            ) {
                Shadowed(
                    color = LightOrange.copy(alpha = 0.7f),
                    offsetX = 4.dp,
                    offsetY = 4.dp,
                    blurRadius = 8.dp
                ) {
                    Image(
                        painter = painterResource(R.drawable.menu_highlight),
                        contentDescription = null,
                    )
                }
            }

            // Menu List
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(LightOrange)
                    .systemBarsPadding(),
            ) {
                stickyHeader(key = "sticky_header") {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(36.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        AppIconButton(
                            modifier = Modifier.padding(top = 24.dp), icon = R.drawable.ic_menu
                        )
                        AppIconButton(
                            modifier = Modifier.padding(vertical = 24.dp),
                            icon = R.drawable.ic_search
                        )
                    }
                }

                itemsIndexed(
                    items = assortment,
                    key = { _, item -> item.assortmentId }) { index, item ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 24.dp)

                    ) {
                        AppImageButton(
                            modifier = Modifier.align(Alignment.Center),
                            icon = item.assortment.icon,
                        ) {
                            selectedIndex = index
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun FoodDisplayingSection(
    modifier: Modifier = Modifier, viewModel: MenuViewModel = koinViewModel()
) {
    val selectedAssortment by viewModel.selectedAssortment.collectAsState()
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
            items(items = selectedAssortment?.products ?: emptyList(), key = { it.productId }) {

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
            items(items = selectedAssortment?.products ?: emptyList(), key = { it.productId }) {

                ProductCard(product = it)

            }
        }

    }
}

@Composable
fun FoodCountries(modifier: Modifier = Modifier, country: List<String>) {
    var selectedIndex by remember { mutableIntStateOf(0) }
    val scrollState = rememberScrollState()

    Row(
        modifier = modifier
            .horizontalScroll(scrollState)
            .padding(end = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        country.forEachIndexed { index, item ->
            Column(
                modifier = Modifier.padding(start = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var textWidth by remember { mutableStateOf(0) }

                Text(modifier = Modifier
                    .clickable {
                        selectedIndex = index
                    }
                    .onGloballyPositioned { layoutCoordinates ->
                        textWidth = layoutCoordinates.size.width
                    }, text = item, style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                    fontWeight = FontWeight.W500,
                    color = Color(0xFF1B1B1B),
                )
                )

                if (index == selectedIndex) {
                    Spacer(
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .width(with(LocalDensity.current) { textWidth.toDp() })
                            .height(2.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(LightOrange)
                    )
                }
            }

            if (index != country.lastIndex) {
                Spacer(
                    modifier = Modifier
                        .width(1.5.dp)
                        .height(24.dp)
                        .background(Color(0xFFE5E5E5))
                )
            }
        }
    }
}

