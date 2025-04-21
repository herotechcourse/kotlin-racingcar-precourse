package racingcar

import racingcar.model.RaceInputs
import racingcar.validator.NameValidator
import racingcar.validator.NumberValidator
import camp.nextstep.edu.missionutils.Console

class InputHandler {
    fun getInputs(): RaceInputs {

        println("Enter the names of the cars (comma-separated):")
        val carNames = Console.readLine()
        val parsedCars = parseCarName(carNames)

        val carsValidator = NameValidator()
        val cars = carsValidator.validate(parsedCars)

        println("How many rounds will be played?")
        val rounds = Console.readLine()

        val roundValidator = NumberValidator()
        val round = roundValidator.validate(rounds)

        return RaceInputs(cars, round)
    }

    internal fun parseCarName (input: String): List<String> {
        return input.split(',')
    }
}