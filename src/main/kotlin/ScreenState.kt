sealed class ScreenState {

    object MainMenu : ScreenState()

    class TypingTest(
        paragraph: String,
        currentIndex: Int,
        incorrectCharacters: Int,
        timeTaken: Int
    ) : ScreenState()

    class TestResult(
        timeTaken: Int,
        wordsPerMinute: Float,
        errorRate: Float
    ) : ScreenState()
}
