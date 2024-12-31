package am.dood.food.menu.presentation.component


import am.dood.food.R
import am.dood.food.menu.domain.model.FoodAssortment
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FoodDisplayingSection(
    modifier: Modifier = Modifier,
    assortment: List<FoodAssortment> = emptyList(),
    selectedAssortment: FoodAssortment? = null,
    pagerState: PagerState,
    onAssortmentChanged: (FoodAssortment) -> Unit = {},
) {


    VerticalPager(
        modifier = modifier.fillMaxSize(),
        state = pagerState,
        pageSpacing = 0.dp,
    ) {
        if (selectedAssortment != null) {
            LaunchedEffect(pagerState.currentPage) {
                onAssortmentChanged(assortment[pagerState.currentPage])
            }
            AssortmentPagerItem(assortment = selectedAssortment)
        } else {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    modifier = Modifier.padding(start = 24.dp, top = 38.dp, bottom = 26.dp),
                    text = "Something went wrong",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                        fontWeight = FontWeight.W600,
                        color = Color(0xFF1B1B1B),
                        textAlign = TextAlign.Center
                    ),
                )
            }
        }
    }
}
