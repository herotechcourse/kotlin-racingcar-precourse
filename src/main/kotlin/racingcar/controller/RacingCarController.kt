package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.CarManager
import racingcar.input.InputReader
import racingcar.view.ViewResult

object RacingCarController {

    fun run() {
        val maxLength = 5

        val prompt1 = "Enter the names of the cars (comma-separated):"
        val carNames = InputReader.readCarNames(prompt1, maxLength)

        val prompt2 = "How many rounds will be played?"
        val rounds = InputReader.readNumberOfRounds(prompt2)

        carNames.forEach { CarManager.addCar(Car(it)) }

        println("\nRace Results")
        repeat(rounds) {
            CarManager.raceAllCars()
            ViewResult.everyRoundResult(CarManager.cars)
            println()
        }

        ViewResult.finalResult()
    }
}