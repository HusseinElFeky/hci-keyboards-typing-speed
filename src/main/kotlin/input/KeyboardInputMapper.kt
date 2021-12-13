package input

import androidx.compose.ui.input.key.Key

interface KeyboardInputMapper {

    fun mapKeyToCharacter(key: Key): Char
}
