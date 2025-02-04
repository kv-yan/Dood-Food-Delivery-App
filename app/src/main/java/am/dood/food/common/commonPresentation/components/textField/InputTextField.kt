package am.dood.food.common.commonPresentation.components.textField

import am.dood.food.R
import am.dood.food.common.commonPresentation.ui.theme.PlaceholderTextStyle
import am.dood.food.common.commonPresentation.ui.theme.TextFieldColor
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun InputTextField(
    modifier: Modifier = Modifier, placeholder: String = stringResource(R.string.empty_string)
) {
    var text by remember { mutableStateOf("") }

    TextField(modifier = modifier.fillMaxWidth(),
        value = text,
        onValueChange = { text = it },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = TextFieldColor,
            unfocusedContainerColor = TextFieldColor,
            disabledContainerColor = TextFieldColor,
            focusedIndicatorColor = Transparent,
            unfocusedIndicatorColor = Transparent,
            cursorColor = Black,
            focusedTextColor = Black,
            unfocusedTextColor = Black,

            ),
        shape = RoundedCornerShape(12.dp),
        placeholder = {
            Text(
                text = placeholder, style = PlaceholderTextStyle
            )
        })

}