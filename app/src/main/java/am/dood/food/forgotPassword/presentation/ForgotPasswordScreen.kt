package am.dood.food.forgotPassword.presentation

import am.dood.food.R
import am.dood.food.common.commonPresentation.components.buttons.GoogleButton
import am.dood.food.common.commonPresentation.components.buttons.SolidButton
import am.dood.food.common.commonPresentation.components.textField.InputTextField
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ForgotPasswordScreen(
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {

        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
                .padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = 84.dp,
                )
                .imePadding()
        ) {

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = stringResource(R.string.recover_password),
                style = TextStyle(
                    fontSize = 36.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                )
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 4.dp,
                        bottom = 24.dp,
                    ),
                text = stringResource(R.string.create_an_account_and_enjoy),
                style = TextStyle(
                    fontSize = 13.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                )
            )

            GoogleButton(
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                text = stringResource(R.string.or),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                )
            )

            InputTextField(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                placeholder = stringResource(R.string.email)
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 4.dp,
                        bottom = 24.dp,
                        start = 8.dp,
                        end = 8.dp,
                    ),
                text = stringResource(R.string.password_reset_instructions),
                style = TextStyle(
                    fontSize = 13.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    fontWeight = FontWeight.Normal,
                    color = Color(0x66000000),
                    textAlign = TextAlign.Start,
                )
            )


            SolidButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 32.dp,
                        start = 24.dp,
                        end = 24.dp,
                    ),
                text = stringResource(R.string.send_code)
            )
        }
    }
}