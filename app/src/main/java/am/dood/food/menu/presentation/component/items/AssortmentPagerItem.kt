package am.dood.food.menu.presentation.component.items

import am.dood.food.R
import am.dood.food.common.commonPresentation.ui.theme.TitleTextStyle
import am.dood.food.menu.domain.model.FoodAssortment
import am.dood.food.menu.domain.model.product.Product
import am.dood.food.menu.presentation.component.FoodCountries
import am.dood.food.menu.presentation.component.items.product_card.ProductCard
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp


@Composable
fun AssortmentPagerItem(
    modifier: Modifier = Modifier,
    assortment: FoodAssortment,
    selectedProduct: Product? = null,
    onMenuVisibilityChanged: (Boolean) -> Unit = {},
    onProductChanged: (Product?) -> Unit = {},
    onAppClose: () -> Unit = {}
) {
    var detailsSourceRow by remember { mutableStateOf<RowType?>(null) }
    val scrollState = rememberScrollState()
    val row1ExpandedItem = remember { mutableStateOf(false) }
    val row2ExpandedItem = remember { mutableStateOf(false) }

    // LazyRow States
    val firstRowState = rememberLazyListState()
    val secondRowState = rememberLazyListState()

    // Function to scroll to selected item
    suspend fun scrollToItem(
        rowState: LazyListState,
        product: Product,
        productList: List<Product>
    ) {

        val index = productList.indexOf(product)
        if (index >= 0) {
            rowState.animateScrollToItem(index)
        }
    }

    LaunchedEffect(selectedProduct) {
        if (selectedProduct != null) {
            val rowState = if (detailsSourceRow == RowType.FIRST) firstRowState else secondRowState
            val productList = if (detailsSourceRow == RowType.FIRST) assortment.products
            else assortment.products.asReversed()
            scrollToItem(rowState, selectedProduct, productList)
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(
                state = scrollState, enabled = selectedProduct == null
            )
            .systemBarsPadding(),
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(), visible = selectedProduct == null
        ) {
            Column {
                Text(
                    modifier = Modifier.padding(start = 24.dp, top = 38.dp, bottom = 26.dp),
                    text = stringResource(R.string.what_food_do_you_want),
                    style = TitleTextStyle
                )

                FoodCountries(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 24.dp, top = 24.dp, bottom = 12.dp),
                    listOf(
                        stringResource(R.string.food_country_all),
                        stringResource(R.string.food_country_georgia),
                        stringResource(R.string.food_country_armenia),
                        stringResource(R.string.food_country_russia),
                        stringResource(R.string.food_country_italy),
                        stringResource(R.string.food_country_france)
                    )
                )
            }
        }

        AnimatedVisibility(
            visible = selectedProduct == null || detailsSourceRow == RowType.FIRST
        ) {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                state = firstRowState,
                userScrollEnabled = selectedProduct == null // Disable user scroll when a product is selected
            ) {
                items(items = assortment.products, key = { it.productId }) {
                    ProductCard(
                        product = it, isExpanded = row1ExpandedItem, onAppClose = onAppClose
                    ) { menuVisible ->
                        onProductChanged(if (menuVisible) null else it)
                        onMenuVisibilityChanged(menuVisible)
                        detailsSourceRow = if (!menuVisible) RowType.FIRST else null
                        row1ExpandedItem.value = !menuVisible
                    }
                }
            }
        }

        AnimatedVisibility(visible = selectedProduct == null) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, bottom = 12.dp),
                text = stringResource(R.string.recommendation),
                style = TitleTextStyle
            )
        }

        AnimatedVisibility(
            visible = selectedProduct == null || detailsSourceRow == RowType.SECOND
        ) {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                state = secondRowState,
                userScrollEnabled = selectedProduct == null,
            ) {
                items(items = assortment.products.asReversed(), key = { it.productId }) {
                    ProductCard(
                        product = it, isExpanded = row2ExpandedItem, onAppClose = onAppClose
                    ) { menuVisible ->
                        row2ExpandedItem.value = !menuVisible
                        onMenuVisibilityChanged(menuVisible)
                        onProductChanged(if (menuVisible) null else it)
                        detailsSourceRow = if (!menuVisible) RowType.SECOND else null
                    }
                }
            }
        }
    }
}

// Enum to track the row type
enum class RowType {
    FIRST, SECOND
}
