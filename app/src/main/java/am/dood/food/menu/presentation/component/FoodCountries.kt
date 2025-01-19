package am.dood.food.menu.presentation.component

import am.dood.food.common.commonPresentation.ui.theme.LightGray
import am.dood.food.common.commonPresentation.ui.theme.LightOrange
import am.dood.food.common.commonPresentation.ui.theme.MediumTextStyle
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp


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
                var textWidth by remember { mutableIntStateOf(0) }

                Text(modifier = Modifier
                    .clickable {
                        selectedIndex = index
                    }
                    .onGloballyPositioned { layoutCoordinates ->
                        textWidth = layoutCoordinates.size.width
                    }, text = item, style = MediumTextStyle
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
                        .background(LightGray)
                )
            }
        }
    }
}
