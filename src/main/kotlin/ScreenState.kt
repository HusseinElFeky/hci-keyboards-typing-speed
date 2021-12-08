sealed class ScreenState {

    object MainMenu : ScreenState()

    class TypingTest(
        val paragraph: String,
        val currentIndex: Int,
        val incorrectCharacters: Int,
        val timeTaken: Int
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
        val timeTaken: Int,
        val wordsPerMinute: Float,
        val errorRate: Float
    ) : ScreenState()
}
