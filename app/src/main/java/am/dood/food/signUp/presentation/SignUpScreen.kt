package am.dood.food.signUp.presentation

import am.dood.food.R
import am.dood.food.common.commonPresentation.components.buttons.GoogleButton
import am.dood.food.common.commonPresentation.components.buttons.SolidButton
import am.dood.food.common.commonPresentation.components.text.SpannableText
import am.dood.food.common.commonPresentation.components.textField.InputTextField
import am.dood.food.common.commonPresentation.ui.theme.CenteredTextStyle
import am.dood.food.common.commonPresentation.ui.theme.LargeTitleTextStyle
import am.dood.food.common.commonPresentation.ui.theme.SmallTextStyle
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    onSignInClick: () -> Unit = {},
    navigateToMenu: () -> Unit = {},
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
                .imePadding()
                .fillMaxWidth()
                .padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = 84.dp,
                )
        ) {

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.create_account),
                style = LargeTitleTextStyle
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 4.dp,
                        bottom = 24.dp
                    ),
                text = stringResource(R.string.create_an_account_and_enjoy),
                style = SmallTextStyle
            )

            GoogleButton(
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                text = stringResource(R.string.or),
                style = CenteredTextStyle
            )

            InputTextField(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                placeholder = stringResource(R.string.full_name)
            )

            InputTextField(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                placeholder = stringResource(R.string.email_or_phone)
            )

            InputTextField(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                placeholder = stringResource(R.string.password)
            )

            SolidButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 32.dp,
                        start = 24.dp,
                        end = 24.dp,
                    ),
                text = stringResource(R.string.sign_in)
            ) {
                navigateToMenu()
            }

            SpannableText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                fullText = stringResource(R.string.already_have_an_account),
                underlineText = stringResource(R.string.login),
                color = Color.Black,
                fontSize = 13,
                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                fontWeight = FontWeight.Normal,
            ) {
                onSignInClick()
            }
        }
    }
}