sealed class ScreenState {

    object MainMenu : ScreenState()

    data class TypingTest(
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

    data class TestResult(
        val timeTaken: Int,
        val wordsPerMinute: Float,
        val accuracy: Float
    ) : ScreenState() {

        companion object {
            fun create(timeTaken: Int, totalWords: Int, correctCharacters: Int, incorrectCharacters: Int): TestResult {
                val totalCharacters = correctCharacters + incorrectCharacters
                val wordsPerMinute = totalWords / (timeTaken / 60.0f)
                return TestResult(
                    timeTaken = timeTaken,
                    wordsPerMinute = wordsPerMinute,
                    accuracy = correctCharacters / totalCharacters.toFloat()
                )
            }
        }
    }
}
