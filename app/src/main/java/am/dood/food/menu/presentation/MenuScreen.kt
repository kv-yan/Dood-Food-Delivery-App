package am.dood.food.menu.presentation

import am.dood.food.R
import am.dood.food.common.commonPresentation.components.image.AppIconButton
import am.dood.food.common.commonPresentation.ui.theme.LightOrange
import am.dood.food.menu.presentation.component.FoodDisplayingSection
import am.dood.food.menu.presentation.component.LeftMenu
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

@Composable
fun MenuScreen(
    modifier: Modifier = Modifier,
    viewModel: MenuViewModel = koinViewModel(),
    onChangeTheme: (isDarkTheme: Boolean) -> Unit = {},
    onAppClose: () -> Unit = {},
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
                onAppClose = onAppClose
            )
        }
    }

}

@Composable
private fun MenuContent(
    modifier: Modifier = Modifier,
    viewModel: MenuViewModel,
    onAppClose: () -> Unit = {},
) {
    val isShowingScreen by viewModel.isShowingScreen.collectAsState()
    val isShowingLeftMenu by viewModel.isShowingLeftMenu.collectAsState()

    val screensState by viewModel.screenState.collectAsState()
    val screenSuccessState = screensState as? MenuScreenState.Success
    val assortment = screenSuccessState?.assortment ?: emptyList()
    val selectedAssortment by viewModel.selectedAssortment.collectAsState()
    val selectedAssortmentIndex by viewModel.selectedAssortmentIndex.collectAsState(0)
    val selectedProduct by viewModel.selectedProduct.collectAsState()

    val pagerState = rememberPagerState(0) { assortment.size }

    LaunchedEffect(selectedAssortmentIndex) {
        pagerState.scrollToPage(selectedAssortmentIndex)
    }


    LaunchedEffect(Unit) {
        delay(200)
        viewModel.setShowingScreen(true)
    }

    println("isShowingScreen && isShowingLeftMenu = ${isShowingScreen && isShowingLeftMenu} ")
    println("isShowingScreen :: $isShowingScreen \nisShowingLeftMenu :: $isShowingLeftMenu ")
    println("________________________________________________________________________")

    Box(modifier = modifier.fillMaxSize()) {
        LeftMenu(
            modifier = Modifier.align(Alignment.TopStart),
            assortment = assortment,
            isShowingMenu = isShowingScreen && isShowingLeftMenu,
            selectedIndex = selectedAssortmentIndex,
            onAssortmentChanged = {
                viewModel.selectAssortment(
                    item = it,
                    index = assortment.indexOf(it),
                )
            }
        )

        AnimatedVisibility(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = if (isShowingLeftMenu) 52.dp else 0.dp),
            visible = isShowingScreen,
            enter = slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(durationMillis = 550),
            ),
        ) {
            Box(modifier = Modifier.fillMaxSize()) {

                FoodDisplayingSection(
                    assortment = assortment,
                    selectedAssortment = selectedAssortment,
                    selectedProduct = selectedProduct,
                    pagerState = pagerState,
                    onAssortmentChanged = {
                        val index = assortment.indexOf(it)
                        viewModel.selectAssortment(it, index)
                    },
                    onMenuVisibilityChanged = {
                        viewModel.setShowingLeftMenu(it)
                    },
                    onProductChanged = {
                        viewModel.setSelectProduct(it)
                    },
                    onAppClose = onAppClose
                )

                AppIconButton(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .systemBarsPadding()
                        .padding(
                            top = 24.dp,
                            end = 8.dp,
                        ),
                    icon = R.drawable.ic_bag,
                    buttonColor = LightOrange
                )
            }
        }
    }
}