package racingcar

import racingcar.model.Car
import racingcar.io.InputHandler
import racingcar.model.RacingGame
import racingcar.io.OutputHandler

fun main() {
    val inputHandler = InputHandler()
    val outputHandler = OutputHandler()

    val carNames = inputHandler.getCarNames()
    val rounds = inputHandler.getNumberOfRounds()
    
    val cars = carNames.map { Car(it) }

    val racingGame = RacingGame(cars, rounds)

    outputHandler.printRaceResults(racingGame.getCars())

    while(!racingGame.isGameOver()) {
        racingGame.playRound()
        outputHandler.printRoundResults(racingGame.getCars())
    }

    outputHandler.printWinners(racingGame.getWinners())
}
