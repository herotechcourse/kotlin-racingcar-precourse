package racingcar

import racingcar.input.RaceInputHandler
import racingcar.view.InputView
import racingcar.view.ResultView


fun main() {
    val carNamesInput = InputView.readCarNames()
    val roundsInput = InputView.readRounds()

    val game = RaceInputHandler.createRace(carNamesInput, roundsInput)

    ResultView.printHeader()
    game.start()
    game.printWinners()

}


