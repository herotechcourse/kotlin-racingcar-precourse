package racingcar.service

import camp.nextstep.edu.missionutils.Console
import racingcar.service.Validator.validatePositiveRoundCount
import racingcar.model.Car
import racingcar.service.Validator.validateCarName

object InputHandler {
    fun inputRounds(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()

        validatePositiveRoundCount(input)

        return input.toInt()
    }

    fun inputCars(): List<Car> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()

        return parseCarNames(input)
    }

    private fun parseCarNames(input: String): List<Car> {
        return input.split(",")
            .onEach { validateCarName(it) }
            .map { Car(it) }
    }

}