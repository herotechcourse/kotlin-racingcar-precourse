package racingcar

object InputParser {
    fun parseCarNames(input: String): List<Car> {
        val carNames = input.split(",").map { it.trim() }
        val invalidNames = carNames.filter { name -> name.length > 5 }

        if (invalidNames.isNotEmpty()) {
            throw IllegalArgumentException("Car name(s) '${invalidNames.joinToString(", ")}' exceed 5 character limit.")
        }

        return carNames.map { name ->
            if (name.isBlank()) {
                throw IllegalArgumentException("Car name cannot be empty.")
            }
            Car(name)
        }
    }

    fun parseNumberOfRounds(input: String): Int {
        try {
            val round = input.toInt()
            if (round <= 0) {
                throw IllegalArgumentException("Number of rounds must be a positive integer.")
            }
            return round
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Invalid input. Please enter a valid integer.")
        }
    }

}