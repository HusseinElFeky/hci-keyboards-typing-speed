import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.type
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

@ExperimentalComposeUiApi
fun main() = application {

    val windowState = rememberWindowState(placement = WindowPlacement.Fullscreen)
    val screenState = remember { mutableStateOf<ScreenState>(ScreenState.MainMenu) }
    val keyboardLayout = remember { mutableStateOf(KeyboardLayout.QWERTY) }

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
                when (screenState.value) {
                    ScreenState.MainMenu -> {
                        renderMainMenu(screenState, keyboardLayout)
                    }
                    is ScreenState.TypingTest -> {
                        renderTypingTest(screenState, keyboardLayout)
                    }
                    is ScreenState.TestResult -> {
                        renderTestResult(screenState, keyboardLayout)
                    }
                }
            }
        }
    }
}

@Composable
fun renderMainMenu(screenState: MutableState<ScreenState>, keyboardLayout: MutableState<KeyboardLayout>) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.wrapContentHeight(),
            text = "Keyboards \uD83E\uDD37\u200D♂️\uD83E\uDD37\u200D♂️",
            textAlign = TextAlign.Center,
            fontSize = 60.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Row(
            modifier = Modifier.wrapContentHeight(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            KeyboardLayout.values().forEach { layout ->
                Row(
                    modifier = Modifier.wrapContentWidth().padding(30.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = layout == keyboardLayout.value,
                        colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF4C597D)),
                        onClick = {
                            keyboardLayout.value = layout
                        }
                    )
                    ClickableText(
                        text = AnnotatedString(layout.name),
                        style = TextStyle(fontSize = 20.sp),
                        onClick = {
                            keyboardLayout.value = layout
                        }
                    )
                }
            }
        }
        Button(
            modifier = Modifier.wrapContentHeight(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF4C597D)),
            onClick = {
                screenState.value = ScreenState.TypingTest.create()
            }
        ) {
            Text(
                text = "Start Test",
                color = Color.White,
                fontSize = 40.sp
            )
        }
    }
}

@Composable
fun renderTypingTest(screenState: MutableState<ScreenState>, keyboardLayout: MutableState<KeyboardLayout>) {

}

@Composable
fun renderTestResult(screenState: MutableState<ScreenState>, keyboardLayout: MutableState<KeyboardLayout>) {

}
