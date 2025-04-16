package racingcar

object Input {
    fun parseCarNames(names: String): List<String> {
        val carNames = names.split(",").map { name -> name.trim() }
        if (carNames.any { name -> name.length > 5 || name.isEmpty() || !name.all { char -> char.isLetter() } }) {
            throw IllegalArgumentException("Car name must be between 1 and 5 characters long and contain only letters.")
        }
        if (carNames.size <= 1) {
            throw IllegalArgumentException("There must be more than one car name.")
        }
        return carNames
    }

    fun parseNumberOfRounds(number: String): Int {
        val parseNumber = number.toIntOrNull()
        if (parseNumber == null) {
            throw IllegalArgumentException("Count must be a valid number.")
        }
        if (parseNumber <= 0) {
            throw IllegalArgumentException("Count must be a positive number.")
        }
        return parseNumber
    }
}