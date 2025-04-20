package racingcar

import racingcar.controller.RacingManager
import racingcar.model.Car
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val carNames = InputView.readCarNames()
    val cars = carNames.map { name ->
        Car(name)
    }
    val roundCount = InputView.readRoundCount()
    val manager = RacingManager(cars, roundCount)
    println("\nRace Results")
    while (manager.isRacing()) {
        manager.moveAllCars()
        ResultView.printRace(manager.cars)
        manager.goNextRound()
    }
    val winners = manager.findWinners()
    ResultView.printWinners(winners)
    return
}
