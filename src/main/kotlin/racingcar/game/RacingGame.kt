package racingcar.game

import camp.nextstep.edu.missionutils.Randoms
import racingcar.car.Car
import racingcar.constants.Constants
import racingcar.constants.Messages
import racingcar.io.InputHandler
import racingcar.io.OutputPrinter
import racingcar.validator.InputValidator

object RacingGame {
    fun run() {
        val carNames = readValidCarNames()
        val roundCount = readValidRoundCount()
        val cars = carNames.map { Car(it) }

        OutputPrinter.printResultHeader()
        repeat(roundCount) {
            playRound(cars)
            OutputPrinter.printRoundSeparator()
        }

        val winners = findWinners(cars)
        OutputPrinter.printWinners(winners.map { it.name })
    }

    private fun readValidCarNames(): List<String> {
        val carNamesInput = InputHandler.readInput(Messages.Prompt.CAR_NAME_INPUT)
        InputValidator.checkEmptyInput(carNamesInput)
        val carNames = carNamesInput.split(Constants.DELIMITER).map { it.trim() }
        InputValidator.validateCarNames(carNames)

        return carNames
    }

    private fun readValidRoundCount(): Int {
        val roundCountsInput = InputHandler.readInput(Messages.Prompt.ROUND_COUNT_INPUT).trim()
        InputValidator.validateRoundCount(roundCountsInput)

        return roundCountsInput.toInt()
    }

    private fun playRound(cars: List<Car>) {
        cars.forEach { car ->
            val randomNumber = Randoms.pickNumberInRange(
                Constants.MIN_RANDOM_RANGE,
                Constants.MAX_RANDOM_RANGE
            )
            car.tryMoveForward(randomNumber)
            OutputPrinter.printCarPosition(car.name, car.position)
        }
    }

    private fun findWinners(cars: List<Car>): List<Car> {
        val max = cars.maxOf { it.position }
        return cars.filter { it.position == max }
    }
}