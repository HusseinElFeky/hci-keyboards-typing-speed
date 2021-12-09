import util.TimestampFormatter
import java.text.DecimalFormat

sealed class ScreenState {

    object MainMenu : ScreenState()

    data class TypingTest(
        val paragraph: String,
        val currentIndex: Int,
        val incorrectCharacters: Int,
        val timeTakenMs: Long
    ) : ScreenState() {

        companion object {
            fun create(): TypingTest {
                return TypingTest(
                    paragraph = "Technology refers to the practical application of scientific knowledge for a purpose. It also includes the capability and skills required to apply the knowledge. Technology enhances the usefulness of goods and services in a safe manner.",
                    currentIndex = 0,
                    incorrectCharacters = 0,
                    timeTakenMs = 0
                )
            }
        }
    }

    data class TestResult(
        val timeTakenMs: Long,
        val wordsPerMinute: Float,
        val accuracy: Float
    ) : ScreenState() {

        fun getTimestampFormatted(): String {
            return TimestampFormatter.formatAsElapsedTime(timeTakenMs)
        }

        fun getWordsPerMinuteFormatted(): String {
            return DecimalFormat("0.00 wpm").format(wordsPerMinute)
        }

        fun getAccuracyPercentageFormatted(): String {
            return DecimalFormat("0.00%").format(accuracy)
        }

        companion object {
            fun create(
                timeTakenMs: Long,
                totalWords: Int,
                correctCharacters: Int,
                incorrectCharacters: Int
            ): TestResult {
                val totalCharacters = correctCharacters + incorrectCharacters
                val wordsPerMinute = totalWords / (timeTakenMs / (1000f * 60f))
                return TestResult(
                    timeTakenMs = timeTakenMs,
                    wordsPerMinute = wordsPerMinute,
                    accuracy = correctCharacters / totalCharacters.toFloat()
                )
            }
        }
    }
}
