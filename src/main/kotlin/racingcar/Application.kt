package racingcar

import racingcar.domain.*
import racingcar.io.InputHandler
import racingcar.io.ResultPrinter

fun main() {
    val cars = createCars()
    val roundNumber = readRoundNumber()
    val raceGame = RaceGame(cars, roundNumber, ResultPrinter())

    startRace(raceGame)
}

fun createCars(): List<Car> {
    val inputHandler = InputHandler()
    val carNames = inputHandler.readCarNames()
    return prepareCars(carNames, RandomEngine())
}

fun readRoundNumber(): Int {
    return InputHandler().readRoundNumber()
}

fun startRace(raceGame: RaceGame) {
    val resultPrinter = ResultPrinter()
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