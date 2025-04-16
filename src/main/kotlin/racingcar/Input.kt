package racingcar

object Input {
    fun parseCarNames(names: String): List<String> {
        if (names.isBlank()) {
            throw IllegalArgumentException()
        }
        val carNames = names.split(",").map { name -> name.trim() }
        val uniqueCarNames = carNames.toSet()
        if (uniqueCarNames.size != carNames.size) {
            throw IllegalArgumentException()
        }
        if (carNames.any { name -> name.length > 5 || name.isEmpty() || !name.all { char -> char.isLetter() } }) {
            throw IllegalArgumentException()
        }
        return carNames
    }

    fun parseNumberOfRounds(number: String): Int {
        if (number.isBlank()) {
            throw IllegalArgumentException()
        }
        val parseNumber = number.toIntOrNull()
        if (parseNumber == null || parseNumber <= 0) {
            throw IllegalArgumentException()
        }
        return parseNumber
    }
}