sealed class ScreenState {

    object MainMenu : ScreenState()

    class TypingTest(
        paragraph: String,
        currentIndex: Int,
        incorrectCharacters: Int,
        timeTaken: Int
    ) : ScreenState() {

        companion object {
            fun create(): TypingTest {
                return TypingTest(
                    paragraph = "Technology refers to the practical application of scientific knowledge for a purpose. It also includes the capability and skills required to apply the knowledge. Technology enhances the usefulness of goods and services in a safe manner.",
                    currentIndex = 0,
                    incorrectCharacters = 0,
                    timeTaken = 0
                )
            }
        }
    }

    class TestResult(
        timeTaken: Int,
        wordsPerMinute: Float,
        errorRate: Float
    ) : ScreenState()
}
