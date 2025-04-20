package racingcar.view
import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine() ?: throw IllegalArgumentException("Input cannot be null")
        val names = input.split(",")
        if (names.any { it.isBlank() || it.length > 5 }) {
            throw IllegalArgumentException("Each name must be non-empty and up to 5 characters.")
        }
        if (names.toSet().size != names.size) {
            throw IllegalArgumentException("Duplicate car names are not allowed.")
        }
        return names
    }

    fun readRoundCount(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()
        if (input.isNullOrBlank()) throw IllegalArgumentException("Input cannot be empty.")
        val count = input.toIntOrNull() ?: throw IllegalArgumentException("Must enter a number.")
        if (count < 0) throw IllegalArgumentException("Round count must be 0 or more.")
        return count

    }
}