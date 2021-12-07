import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.type
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

@ExperimentalComposeUiApi
fun main() = application {

    val windowState = rememberWindowState(placement = WindowPlacement.Fullscreen)
    var screenState = remember<ScreenState> { ScreenState.MainMenu }
    var keyboardLayout = remember { KeyboardLayout.QWERTY }

    var text by remember { mutableStateOf("Hello, World!") }

    Window(
        state = windowState,
        onCloseRequest = ::exitApplication,
        onPreviewKeyEvent = {
            if (it.type == KeyEventType.KeyDown && it.key == Key.Escape) {
                exitApplication()
                true
            } else {
                false
            }
        },
        undecorated = true
    ) {
        MaterialTheme {
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource("images/bg_default.jpg"),
                    contentDescription = "Window Background",
                    contentScale = ContentScale.FillBounds
                )
                when (screenState) {
                    ScreenState.MainMenu -> {
                        Button(onClick = {
                            text = "Hello, Desktop!"
                        }) {
                            Text(text)
                        }
                    }
                    is ScreenState.TypingTest -> {

                    }
                    is ScreenState.TestResult -> {

                    }
                }
            }
        }
    }
}
