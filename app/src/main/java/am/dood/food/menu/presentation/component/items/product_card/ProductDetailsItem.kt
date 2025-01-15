package am.dood.food.menu.presentation.component.items.product_card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ProductDetailsItem(modifier: Modifier = Modifier, title: String, image: Int) {

    Row {
        Image(
            modifier = modifier.size(16.dp),
            painter = painterResource(id = image),
            contentDescription = title
        )

        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = title,
            fontSize = 12.sp
        )
    }

}
