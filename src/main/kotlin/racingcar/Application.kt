package racingcar

import racingcar.view.InputView
import racingcar.view.OutputView
import racingcar.domain.Race

fun main() {
    Application().start()
}

class Application {
    fun start() {
        val carNames = InputView.readCarNames()
        val roundCount = InputView.readRoundCount()
        val race = Race.fromNames(carNames)

        println("\n🏁 Race Start!")
        repeat(roundCount) {
            race.moveAll()
            OutputView.printRoundResult(race.cars)
            println()
        }

        val winners = race.findWinners()
        OutputView.printWinners(winners)
    }
}
