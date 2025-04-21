package racingcar.controller

import racingcar.model.Car
import racingcar.view.printResult
import racingcar.view.printRoundResult
import racingcar.view.readCarName
import racingcar.view.readRoundCount

class RacingGame() {
    fun play() {
        val carNames = readCarName()
        val rounds = readRoundCount()
        val cars = carNames.map { Car(it) }
        val gameState = GameState(cars)

        repeatRounds(rounds, cars)
        val winners = gameState.getWinners().joinToString(", ")
        printResult(winners)
    }

    private fun repeatRounds(rounds: Int, cars: List<Car>) {
        repeat(rounds) {
            moveCar(cars)
            printRoundResult(cars)
        }
    }

    private fun moveCar(cars: List<Car>) {
        cars.forEach {
            it.move()
        }
    }
}


