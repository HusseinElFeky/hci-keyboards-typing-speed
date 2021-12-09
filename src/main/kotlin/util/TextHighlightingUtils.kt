import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.TextLayoutResult

fun TextLayoutResult.getBoundingBoxesForRange(start: Int, end: Int): List<Rect> {
    val boundingBoxes = mutableListOf<Rect>()
    for (i in start until end) {
        boundingBoxes.add(getBoundingBox(i))
    }
    return boundingBoxes
}

fun TextLayoutResult.getBoxesPath(start: Int, end: Int): Path {
    return Path().apply {
        val boundingBoxes = getBoundingBoxesForRange(start, end)
        val cornerRadius = CornerRadius(x = 10f, y = 10f)

        for (i in boundingBoxes.indices) {
            val boundingBox = boundingBoxes[i]
            addRoundRect(
                RoundRect(
                    boundingBox.withPadding(
                        leftPadding = 2f,
                        topPadding = 0f,
                        rightPadding = -6f,
                        bottomPadding = 0f
                    ),
                    topLeft = cornerRadius,
                    topRight = cornerRadius,
                    bottomRight = cornerRadius,
                    bottomLeft = cornerRadius,
                )
            )
        }
    }
}

fun Rect.withPadding(horizontalPadding: Float = 0f, verticalPadding: Float = 0f): Rect {
    return Rect(
        left = left - horizontalPadding,
        top = top - verticalPadding,
        right = right + horizontalPadding,
        bottom = bottom + verticalPadding,
    )
}

fun Rect.withPadding(
    leftPadding: Float = 0f,
    topPadding: Float = 0f,
    rightPadding: Float = 0f,
    bottomPadding: Float = 0f
): Rect {
    return Rect(
        left = left - leftPadding,
        top = top - topPadding,
        right = right + rightPadding,
        bottom = bottom + bottomPadding,
    )
}
