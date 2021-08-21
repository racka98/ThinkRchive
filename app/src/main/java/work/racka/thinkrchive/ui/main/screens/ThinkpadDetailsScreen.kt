package work.racka.thinkrchive.ui.main.screens

import android.content.res.Configuration
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.navigationBarsPadding
import work.racka.thinkrchive.data.model.Thinkpad
import work.racka.thinkrchive.ui.components.DetailsCards
import work.racka.thinkrchive.ui.components.TopCardWithImage
import work.racka.thinkrchive.ui.theme.Dimens
import work.racka.thinkrchive.ui.theme.ThinkRchiveTheme
import work.racka.thinkrchive.utils.Constants

@ExperimentalAnimationApi
@Composable
fun ThinkpadDetailsScreen(
    modifier: Modifier = Modifier,
    thinkpad: Thinkpad,
    onBackButtonPressed: () -> Unit = { },
    onExternalLinkClicked: () -> Unit = { },
    listState: LazyListState = rememberLazyListState()
) {

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopCardWithImage(
                imageUrl = thinkpad.imageUrl,
                onBackButtonPressed = onBackButtonPressed,
                listState = listState
            )
        }
    ) {
        LazyColumn(
            state = listState,
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            item {
                DetailsCards(
                    thinkpad = thinkpad,
                    onExternalLinkClick = onExternalLinkClicked
                )
            }

            item {
                DetailsCards(
                    thinkpad = thinkpad,
                    onExternalLinkClick = onExternalLinkClicked
                )
            }

            // Always at the bottom
            item { Spacer(modifier = Modifier.navigationBarsPadding()) }
        }
    }
}


@ExperimentalAnimationApi
@Preview(
    uiMode = Configuration.UI_MODE_TYPE_NORMAL,
    device = Devices.PIXEL_4
)
@Composable
private fun ThinkpadDetailsScreenPreview() {
    ThinkRchiveTheme {
        ThinkpadDetailsScreen(thinkpad = Constants.ThinkpadsListPreview[0])
    }
}