package racingcar

import camp.nextstep.edu.missionutils.Console

object InputParser {
    private const val MAX_NAME_LENGTH: Int = 5

    fun parseCarNames(carNames: String): List<String> {
        if (carNames.isBlank()) throw IllegalArgumentException("Car names cannot be empty.")
        return carNames.split(",")
            .map{ it.trim() }
            .onEach {
                require(it.isNotEmpty() && it.length <= MAX_NAME_LENGTH) {
                    "Car name length must be between 1-5: '$it'"
                }
            }
    }

    fun parseTotalRounds(roundsCount: String): Int {
        val num = roundsCount.trim().toIntOrNull()
            ?: throw IllegalArgumentException("Number of rounds must be a positive integer.")
        require(num > 0) { "Number of rounds must be grater than 0" }
        return num
    }

    fun readCarNames(): List<String> {
        println("Enter car names (comma-separated):")
        return parseCarNames(Console.readLine())
    }

    fun readTotalRounds(): Int {
        println("Enter number of rounds:")
        return parseTotalRounds(Console.readLine())
    }
}