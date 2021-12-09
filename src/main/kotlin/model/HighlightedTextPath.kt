package model

import androidx.compose.ui.graphics.Path

data class HighlightedTextPath(
    val greenPath: Path = Path(),
    val bluePath: Path = Path()
)
