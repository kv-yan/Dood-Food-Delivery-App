package am.dood.food.signIn.presentation

import am.dood.food.R
import am.dood.food.common.commonPresentation.components.buttons.GoogleButton
import am.dood.food.common.commonPresentation.components.buttons.SolidButton
import am.dood.food.common.commonPresentation.components.text.SpannableText
import am.dood.food.common.commonPresentation.components.textField.InputTextField
import androidx.compose.foundation.clickable
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
fun SignInScreen(
    modifier: Modifier = Modifier,
    onSignUpClick: () -> Unit = {},
    onForgotPasswordClick: () -> Unit = {},
    navigateToMenu: () -> Unit = {}
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
                    top = 80.dp,
                )
                .imePadding()
        ) {

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp),
                text = stringResource(R.string.login),
                style = TextStyle(
                    fontSize = 36.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    fontWeight = FontWeight.Normal,
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
                placeholder = stringResource(R.string.email_or_phone)
            )

            InputTextField(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                placeholder = stringResource(R.string.password)
            )

            Box(Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(top = 4.dp)
                        .clickable {
                            onForgotPasswordClick()
                        },
                    text = stringResource(R.string.forget_password),
                    style = TextStyle(
                        fontSize = 11.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        fontWeight = FontWeight.Normal,
                        color = Color(0x66000000),
                        textAlign = TextAlign.End,
                    )
                )

            }
            SolidButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp, start = 24.dp, end = 24.dp),
                text = stringResource(R.string.sign_in)
            ) {
                navigateToMenu()
            }

            SpannableText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                fullText = stringResource(R.string.don_t_have_an_account_sign_up),
                underlineText = stringResource(R.string.sign_up),
                color = Color(0xFF000000),
                fontSize = 13,
                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                fontWeight = FontWeight.Normal,
            ) {
                onSignUpClick()
            }
        }
    }
}