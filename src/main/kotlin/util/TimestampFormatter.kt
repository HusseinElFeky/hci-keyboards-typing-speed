package util

object TimestampFormatter {

    fun formatAsTimer(timestamp: Long): String {
        val millisecondsFormatted = (timestamp % 1000).pad(2)
        val seconds = timestamp / 1000
        val secondsFormatted = (seconds % 60).pad(2)
        val minutes = seconds / 60
        val minutesFormatted = (minutes % 60).pad(2)
        val hours = minutes / 60

        return if (hours > 0) {
            val hoursFormatted = (minutes / 60).pad(2)
            "$hoursFormatted:$minutesFormatted:$secondsFormatted"
        } else {
            "$minutesFormatted:$secondsFormatted.$millisecondsFormatted"
        }
    }

    fun formatAsElapsedTime(timestamp: Long): String {
        val millisecondsFormatted = (timestamp % 1000)
        val seconds = timestamp / 1000

        return if (seconds > 0) {
            val secondsFormatted = (seconds % 60)
            val minutes = seconds / 60

            if (minutes > 0) {
                val minutesFormatted = (minutes % 60)
                val hours = minutes / 60

                if (hours > 0) {
                    val hoursFormatted = (minutes / 60)
                    "${hoursFormatted}h ${minutesFormatted}m ${secondsFormatted}s ${millisecondsFormatted}ms"
                } else {
                    "${minutesFormatted}m ${secondsFormatted}s ${millisecondsFormatted}ms"
                }
            } else {
                "${secondsFormatted}s ${millisecondsFormatted}ms"
            }
        } else {
            "${millisecondsFormatted}ms"
        }
    }

    private fun Long.pad(desiredLength: Int) = this.toString().padStart(desiredLength, '0').substring(0, desiredLength)
}
