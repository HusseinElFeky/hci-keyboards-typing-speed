package input.impl

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.input.key.Key
import input.KeyboardInputMapper

@ExperimentalComposeUiApi
class QwertyInputMapperImpl : KeyboardInputMapper {

    override fun mapKeyToCharacter(key: Key): Char {
        return when (key) {
            Key.A -> 'a'
            Key.B -> 'b'
            Key.C -> 'c'
            Key.D -> 'd'
            Key.E -> 'e'
            Key.F -> 'f'
            Key.G -> 'g'
            Key.H -> 'h'
            Key.I -> 'i'
            Key.J -> 'j'
            Key.K -> 'k'
            Key.L -> 'l'
            Key.M -> 'm'
            Key.N -> 'n'
            Key.O -> 'o'
            Key.P -> 'p'
            Key.Q -> 'q'
            Key.R -> 'r'
            Key.S -> 's'
            Key.T -> 't'
            Key.U -> 'u'
            Key.V -> 'v'
            Key.W -> 'w'
            Key.X -> 'x'
            Key.Y -> 'y'
            Key.Z -> 'z'
            Key.Comma -> ','
            Key.Period -> '.'
            Key.Spacebar -> ' '
            else -> '\u0000'
        }
    }
}
