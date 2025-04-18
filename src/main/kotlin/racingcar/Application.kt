package racingcar

import racingcar.domain.*
import racingcar.io.InputHandler
import racingcar.io.ResultPrinter

fun main() {
    val inputHandler = InputHandler()
    val cars = prepareCars(inputHandler.readCarNames(), engine = RandomEngine())
    val roundNumbers = inputHandler.readRoundNumber()

    val resultPrinter = ResultPrinter()

    val raceGame = RaceGame(cars, roundNumbers, resultPrinter)

    resultPrinter.printRaceResult()
    val resultCars = raceGame.raceAllRound()
    resultPrinter.printWinner(Winner.findWinner(resultCars))
}

fun prepareCars(carNames: List<String>, engine: Engine): List<Car> {
    val cars = mutableListOf<Car>()
    for (carName in carNames) {
        cars.add(Car(carName, 0, engine))
    }
    return cars
}