package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.domain.Car

object InputView {
    private const val CAR_NAME_DELIMITER = ","

    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")

        val input = Console.readLine()
        val carNames = input.split(CAR_NAME_DELIMITER).map { it.trim() }

        validateCarNames(carNames)

        return carNames
    }

    private fun validateCarNames(carNames: List<String>) {
        if (carNames.isEmpty() || carNames.any { it.isBlank() || it.length > Car.MAX_NAME_LENGTH}) {
            throw IllegalArgumentException("Invalid car name(s). Car name must not be empty and should be at most 5 characters.")
        }
    }

    fun readRoundNumber(): Int {
        println("How many rounds will be played?")

        val input = Console.readLine()

        validateRoundNumber(input)

        return input.toInt()
    }

    private fun validateRoundNumber(input: String) {
        input.toIntOrNull()?.takeIf { it > 0 }
            ?: throw IllegalArgumentException("Invalid round number. Round number should be a positive integer.")
    }
}