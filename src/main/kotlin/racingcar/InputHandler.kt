package racingcar

class InputHandler(private val io: IOInterface) {
    fun readCarNames(): List<String> {
        io.print("Enter the names of the cars (comma-separated):")
        val input = io.read()
        val names = input.split(",").map { it.trim() }

        require(names.all { it.isNotEmpty() && it.length <= 5 }) {
            "Each car name must be non-empty and up to 5 characters."
        }

        require(names.size > 1) {
            "There must be more than one car."
        }

        require(names.distinct().size == names.size) {
            "Car names must be unique."
        }

        return names
    }

    fun readRoundCount(): Int {
        io.print("How many rounds will be played?")
        val input = io.read()

        val roundCount = input.toIntOrNull() ?: throw IllegalArgumentException("Round count must be a valid number.")

        require(roundCount > 0) { "Round count must be positive." }

        return roundCount
    }
}
