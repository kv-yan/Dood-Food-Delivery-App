package am.dood.food.menu.presentation.component


import am.dood.food.R
import am.dood.food.common.commonPresentation.ui.theme.CenteredTitleTextStyle
import am.dood.food.menu.domain.model.FoodAssortment
import am.dood.food.menu.domain.model.product.Product
import am.dood.food.menu.presentation.component.items.AssortmentPagerItem
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun FoodDisplayingSection(
    modifier: Modifier = Modifier,
    assortment: List<FoodAssortment> = emptyList(),
    selectedAssortment: FoodAssortment? = null,
    selectedProduct: Product? = null,
    pagerState: PagerState,
    onAssortmentChanged: (FoodAssortment) -> Unit = {},
    onMenuVisibilityChanged: (Boolean) -> Unit = {},
    onProductChanged: (Product?) -> Unit = {},
    onAppClose: () -> Unit = {}
) {

    VerticalPager(
        modifier = modifier.fillMaxSize(),
        state = pagerState,
        pageSpacing = 0.dp,
        userScrollEnabled = false
    ) {
        if (selectedAssortment != null) {
            LaunchedEffect(pagerState.currentPage) {
                onAssortmentChanged(assortment[pagerState.currentPage])
            }
            AssortmentPagerItem(
                selectedProduct = selectedProduct,
                assortment = selectedAssortment,
                onMenuVisibilityChanged = onMenuVisibilityChanged,
                onProductChanged = onProductChanged,
                onAppClose = onAppClose
            )
        } else {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    modifier = Modifier.padding(start = 24.dp, top = 38.dp, bottom = 26.dp),
                    text = stringResource(R.string.something_went_wrong),
                    style = CenteredTitleTextStyle,
                )
            }
        }
    }
}
