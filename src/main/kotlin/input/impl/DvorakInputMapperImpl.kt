package input.impl

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.input.key.Key
import input.KeyboardInputMapper

@ExperimentalComposeUiApi
class DvorakInputMapperImpl : KeyboardInputMapper {

    override fun mapKeyToCharacter(key: Key): Char {
        return when (key) {
            Key.W -> ','
            Key.E -> '.'
            Key.R -> 'p'
            Key.T -> 'y'
            Key.Y -> 'f'
            Key.U -> 'g'
            Key.I -> 'c'
            Key.O -> 'r'
            Key.P -> 'l'
            Key.A -> 'a'
            Key.S -> 'o'
            Key.D -> 'e'
            Key.F -> 'u'
            Key.G -> 'i'
            Key.H -> 'd'
            Key.J -> 'h'
            Key.K -> 't'
            Key.L -> 'n'
            Key.Semicolon -> 's'
            Key.X -> 'q'
            Key.C -> 'j'
            Key.V -> 'k'
            Key.B -> 'x'
            Key.N -> 'b'
            Key.M -> 'm'
            Key.Comma -> 'w'
            Key.Period -> 'v'
            Key.Slash -> 'z'
            Key.Spacebar -> ' '
            else -> '\u0000'
        }
    }
}
