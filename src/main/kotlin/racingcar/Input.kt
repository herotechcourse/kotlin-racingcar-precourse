package racingcar

object Input {
    fun parseCarNames(names: String): List<String> {
        val carNames = names.split(",").map { name -> name.trim() }
        if (carNames.any { name -> name.length > 5 || name.isEmpty() || !name.all { char -> char.isLetter() } }) {
            throw IllegalArgumentException()
        }
        if (carNames.size <= 1) {
            throw IllegalArgumentException()
        }
        return carNames
    }

    fun parseNumberOfRounds(number: String): Int {
        val parseNumber = number.toIntOrNull()
        if (parseNumber == null) {
            throw IllegalArgumentException()
        }
        if (parseNumber <= 0) {
            throw IllegalArgumentException()
        }
        return parseNumber
    }
}