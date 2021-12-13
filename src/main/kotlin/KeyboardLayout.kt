import androidx.compose.ui.ExperimentalComposeUiApi
import input.KeyboardInputMapper
import input.impl.AlphabeticalInputMapperImpl
import input.impl.ColemakInputMapperImpl
import input.impl.DvorakInputMapperImpl
import input.impl.QwertyInputMapperImpl

@ExperimentalComposeUiApi
enum class KeyboardLayout(val imageName: String) {

    QWERTY("keyboard_qwerty.png"),
    DVORAK("keyboard_dvorak.png"),
    COLEMAK("keyboard_colemak.png"),
    ALPHABETICAL("keyboard_alphabetical.jpg");

    fun toKeyboardInputMapper(): KeyboardInputMapper {
        return when (this) {
            QWERTY -> QwertyInputMapperImpl()
            DVORAK -> DvorakInputMapperImpl()
            COLEMAK -> ColemakInputMapperImpl()
            ALPHABETICAL -> AlphabeticalInputMapperImpl()
        }
    }
}
