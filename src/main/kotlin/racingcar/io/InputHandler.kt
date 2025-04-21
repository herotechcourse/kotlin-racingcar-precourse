package racingcar.io

import camp.nextstep.edu.missionutils.Console

class InputHandler {
    fun getCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        val carNames = input.split(",").map { it.trim() }
        
        validateCarNames(carNames)
        return carNames
    }

    fun getRounds(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()
        
        return validateRounds(input)
    }

    private fun validateCarNames(carNames: List<String>) {
        require(carNames.isNotEmpty()) { "At least one car name must be provided" }
    }

    private fun validateRounds(input: String): Int {
        try {
            val rounds = input.toInt()
            require(rounds > 0) { "Number of rounds must be positive" }
            return rounds
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Number of rounds must be a valid integer")
        }
    }
}