package am.dood.food.menu.presentation.component


import am.dood.food.R
import am.dood.food.common.commonPresentation.components.image.AppIconButton
import am.dood.food.common.commonPresentation.components.image.AppImageButton
import am.dood.food.common.commonPresentation.components.image.Shadowed
import am.dood.food.common.commonPresentation.ui.theme.LightOrange
import am.dood.food.menu.domain.model.FoodAssortment
import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import androidx.compose.ui.zIndex

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UseOfNonLambdaOffsetOverload")
@Composable
fun LeftMenu(
    modifier: Modifier,
    assortment: List<FoodAssortment>,
    isShowingMenu: Boolean,
    onAssortmentChanged: (FoodAssortment) -> Unit,
    selectedIndex: Int = 0
) {

    AnimatedVisibility(
        modifier = modifier
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

                items(items = assortment,
                    key = { item -> item.assortmentId }) { item ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 24.dp)

                    ) {
                        AppImageButton(
                            modifier = Modifier.align(Alignment.Center),
                            icon = item.assortment.icon,
                        ) {
                            onAssortmentChanged(item)
                        }
                    }
                }
            }
        }
    }
}
