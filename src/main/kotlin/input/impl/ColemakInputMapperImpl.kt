package input.impl

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.input.key.Key
import input.KeyboardInputMapper

@ExperimentalComposeUiApi
class ColemakInputMapperImpl : KeyboardInputMapper {

    override fun mapKeyToCharacter(key: Key): Char {
        return when (key) {
            Key.Q -> 'q'
            Key.W -> 'w'
            Key.E -> 'f'
            Key.R -> 'p'
            Key.T -> 'g'
            Key.Y -> 'j'
            Key.U -> 'l'
            Key.I -> 'u'
            Key.O -> 'y'
            Key.A -> 'a'
            Key.S -> 'r'
            Key.D -> 's'
            Key.F -> 't'
            Key.G -> 'd'
            Key.H -> 'h'
            Key.J -> 'n'
            Key.K -> 'e'
            Key.L -> 'i'
            Key.Semicolon -> 'o'
            Key.Z -> 'z'
            Key.X -> 'x'
            Key.C -> 'c'
            Key.V -> 'v'
            Key.B -> 'b'
            Key.N -> 'k'
            Key.M -> 'm'
            Key.Comma -> ','
            Key.Period -> '.'
            Key.Spacebar -> ' '
            else -> '\u0000'
        }
    }
}
