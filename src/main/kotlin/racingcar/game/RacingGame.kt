package racingcar.game

import camp.nextstep.edu.missionutils.Randoms
import racingcar.car.Car
import racingcar.constants.Constants
import racingcar.io.InputHandler
import racingcar.io.OutputPrinter
import racingcar.validator.InputValidator

object RacingGame {
    fun run() {
        val carNames = readValidCarNames()
        val roundCount = readValidRoundCount()
        val cars = carNames.map { Car(it) }

        repeat(roundCount) {
            playRound(cars)
            OutputPrinter.printRoundSeparator()
        }

        val winners = findWinners(cars)
        OutputPrinter.printWinners(winners.map { it.name })
    }

    private fun readValidCarNames(): List<String> {
        val carNamesInput = InputHandler.readInput("Enter the names of the cars (comma-separated):")
        InputValidator.checkEmptyInput(carNamesInput)
        val carNames = carNamesInput.split(Constants.DELIMITER).map { it.trim() }
        InputValidator.validateCarNames(carNames)

        return carNames
    }

    private fun readValidRoundCount(): Int {
        val roundCountsInput = InputHandler.readInput("How many rounds will be played?").trim()
        InputValidator.validateRoundCount(roundCountsInput)

        return roundCountsInput.toInt()
    }

    private fun playRound(cars: List<Car>) {
        cars.forEach { car ->
            if (Randoms.pickNumberInRange(
                    Constants.MIN_RANDOM_RANGE,
                    Constants.MAX_RANDOM_RANGE
                ) >= Constants.MIN_RANDOM_TO_MOVE
            ) {
                car.moveForward()
            }
            OutputPrinter.printCarPosition(car.name, car.position)
        }
    }

    private fun findWinners(cars: List<Car>): List<Car> {
        val max = cars.maxOf { it.position }
        return cars.filter { it.position == max }
    }
}