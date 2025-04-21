package racingcar

import racingcar.domain.Race
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val carNames = InputView.readCarNames()
    val roundCount = InputView.readRoundCount()

    val race = Race(carNames)

    println("\nRace Results")
    repeat(roundCount) {
        race.runRound()
        OutputView.printRound(race.getCars())
    }

    val winners = race.getWinners()
    OutputView.printWinners(winners)
}
