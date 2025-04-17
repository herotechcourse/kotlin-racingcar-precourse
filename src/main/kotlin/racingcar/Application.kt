package racingcar

import racingcar.handler.InputHandler
import racingcar.handler.OutputHandler
import racingcar.service.RaceManager

fun main() {
    val carNames = InputHandler.getValidatedCarNames()
    val roundCount = InputHandler.getValidatedRoundCount()
    val cars = RaceManager.createCars(carNames)

    OutputHandler.printRaceIntro()
    RaceManager.simulateRace(cars, roundCount)

    val winners = RaceManager.determineWinners(cars)
    OutputHandler.announceWinners(winners)
}
