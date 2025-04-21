package racingcar

import racingcar.view.InputView
import racingcar.view.ResultView
import racingcar.model.Car
import racingcar.model.Race

fun main() {
    val app = Application()
    app.run()
}

class Application {
    fun run() {
        val names = InputView.readCarNames()
        val cars = names.map { Car(it) }
        val numberOfRounds = InputView.readRoundCount()

        val race = Race(cars)
        val result = race.play(numberOfRounds)

        ResultView.printResultTitle()
        result.forEach { round ->
            ResultView.printRoundResult(round)
        }
        
        val winners = race.findWinners()
        ResultView.printWinner(winners)
    }
}
