package racingcar

import racingcar.domain.RacingGame
import racingcar.io.InputProcess
import racingcar.io.OutputProcess
import racingcar.domain.Car

fun main() {

    val inputProcess = InputProcess()
    val outputProcess = OutputProcess()


    outputProcess.printCarNameInputMessage()
    val carNames = inputProcess.processCarName()


    outputProcess.printRoundNumberInputMessage()
    val rounds = inputProcess.processRoundNumber()
    println()

    val cars = carNames.map { Car(it) }
    val racingGame = RacingGame(cars)


    outputProcess.printRaceResultsMessage()


    repeat(rounds) {
        racingGame.executeRound()
        outputProcess.printRoundResult(cars)
    }


    val winners = racingGame.findWinner()
    outputProcess.printWinners(winners)

}
