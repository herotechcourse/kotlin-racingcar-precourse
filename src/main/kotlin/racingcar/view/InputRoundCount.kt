package racingcar.view

import camp.nextstep.edu.missionutils.Console

object InputRoundCount {
    fun invoke(): Int {
        println("How many rounds will be played?")

        val input = Console.readLine().trim()

        validateNotEmpty(input)
        validateIsNumeric(input)
        validateIsPositive(input)

        return input.toInt()
    }

    private fun validateNotEmpty(input: String) {
        if (input.isBlank()) {
            throw IllegalArgumentException("Number of attempts cannot be blank.")
        }
    }

    private fun validateIsNumeric(input: String) {
        if (input.toIntOrNull() == null) {
            throw IllegalArgumentException("Number of attempts must be a valid number.")
        }
    }

    private fun validateIsPositive(input: String) {
        val number = input.toInt()
        if (number <= 0) {
            throw IllegalArgumentException("Number of attempts must be a positive integer.")
        }
    }
}