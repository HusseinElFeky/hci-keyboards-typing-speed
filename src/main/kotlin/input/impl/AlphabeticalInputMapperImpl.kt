package input.impl

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.input.key.Key
import input.KeyboardInputMapper

@ExperimentalComposeUiApi
class AlphabeticalInputMapperImpl : KeyboardInputMapper {

    override fun mapKeyToCharacter(key: Key): Char {
        return when (key) {
            Key.Q -> 'a'
            Key.W -> 'b'
            Key.E -> 'c'
            Key.R -> 'd'
            Key.T -> 'e'
            Key.Y -> 'f'
            Key.U -> 'g'
            Key.I -> 'h'
            Key.O -> 'i'
            Key.P -> 'j'
            Key.A -> 'k'
            Key.S -> 'l'
            Key.D -> 'm'
            Key.F -> 'n'
            Key.G -> 'o'
            Key.H -> 'p'
            Key.J -> 'q'
            Key.K -> 'r'
            Key.L -> 's'
            Key.Z -> 't'
            Key.X -> 'u'
            Key.C -> 'v'
            Key.V -> 'w'
            Key.B -> 'x'
            Key.N -> 'y'
            Key.M -> 'z'
            Key.Comma -> ','
            Key.Period -> '.'
            Key.Spacebar -> ' '
            else -> '\u0000'
        }
    }
}
