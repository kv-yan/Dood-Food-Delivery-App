package am.dood.food.menu.presentation.component

import am.dood.food.R
import am.dood.food.common.commonPresentation.ui.theme.LightOrange
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


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
