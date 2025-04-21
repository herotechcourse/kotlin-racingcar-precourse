package racingcar

import racingcar.model.RaceInputs
import racingcar.validator.NameValidator
import racingcar.validator.NumberValidator

class InputHandler {
    fun getInputs (): RaceInputs? {

        println("Enter the names of the cars (comma-separated):")
        val car: String = readln()
        val cars: List<String> = car.split(',')

        val carsValidator = NameValidator()
        carsValidator.validate(cars)

        println("How many rounds will be played?")
        val round: String = readln()

        val roundValidator = NumberValidator()
        roundValidator.validate(round)

        return null
    }
}