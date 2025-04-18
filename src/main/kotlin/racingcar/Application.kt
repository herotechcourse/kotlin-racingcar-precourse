package racingcar

import racingcar.InputView
import racingcar.RaceGame


fun main() {
    val names = InputView.readCarNames()
    val rounds = InputView.readRoundCount()

    val raceGame = RaceGame(names, rounds)
    raceGame.start()
}

