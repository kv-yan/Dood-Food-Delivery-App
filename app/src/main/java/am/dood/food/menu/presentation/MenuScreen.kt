@file:OptIn(ExperimentalFoundationApi::class)

package am.dood.food.menu.presentation

import am.dood.food.R
import am.dood.food.common.commonPresentation.components.image.AppIconButton
import am.dood.food.common.commonPresentation.components.image.AppImageButton
import am.dood.food.common.commonPresentation.ui.theme.LightOrange
import am.dood.food.menu.domain.model.FoodAssortment
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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
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
    val pagerState = rememberPagerState { assortment.size }
    val selectedAssortment by viewModel.selectedAssortment.collectAsState()


    LaunchedEffect(Unit) {
        delay(200)
        viewModel.setShowingScreen(true)
    }

    Row(modifier = modifier.fillMaxSize()) {

        LeftMenu(assortment, isShowingScreen)

        // Second AnimatedVisibility (Right to Left)
        AnimatedVisibility(
            modifier = Modifier.weight(1f), visible = isShowingScreen, enter = slideInHorizontally(
                initialOffsetX = { it }, // Start from the right
                animationSpec = tween(durationMillis = 500)
            )
        ) {
            Column {
                HorizontalPager(pagerState) {

                }
            }
            // Content of the second column
        }
    }
}

@SuppressLint("UseOfNonLambdaOffsetOverload")
@Composable
private fun LeftMenu(assortment: List<FoodAssortment>, isShowingMenu: Boolean) {
    var selectedIndex by remember { mutableIntStateOf(0) }

    AnimatedVisibility(
        modifier = Modifier
            .fillMaxHeight()
            .width(52.dp),
        visible = isShowingMenu,
        enter = slideInHorizontally(
            initialOffsetX = { -it }, animationSpec = tween(durationMillis = 300)
        )
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
                Image(
                    painter = painterResource(R.drawable.menu_highlight),
                    contentDescription = null,
                )
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
                    key = { _, item -> item.assortmentId }
                ) { index, item ->
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

