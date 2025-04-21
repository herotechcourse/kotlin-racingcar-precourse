package racingcar.input

import camp.nextstep.edu.missionutils.Console

class InputReader {

    fun readAndGetCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = readInput()
        val carNames = parseCarNames(input)
        validateCarNames(carNames)
        return carNames
    }

    fun readAndGetRounds(): Int {
        println("How many rounds will be played?")
        val input = readInput()
        val rounds = parseRounds(input)
        validateRounds(rounds)
        return rounds
    }

    private fun readInput(): String {
        return Console.readLine()
    }

    private fun parseCarNames(input: String): List<String> {
        require(input.isNotBlank()) { "Car names must not be empty" }
        return input.split(",").map { it.trim() }
    }

    private fun validateCarNames(carNames: List<String>) {
        require(carNames.size == carNames.distinct().size) { "Car names must be unique" }
        carNames.forEach {
            require(it.length <= 5) { "CarName exceeds 5 characters" }
        }
    }

    private fun parseRounds(input: String): Int {
        return input.toIntOrNull() ?: throw IllegalArgumentException("Rounds must not be empty")
    }

    private fun validateRounds(rounds: Int) {
        require(rounds > 0) { "Rounds should be greater than 0" }
    }
}