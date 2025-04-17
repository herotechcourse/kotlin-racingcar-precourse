package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.domain.Car
import racingcar.domain.RacingGame
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val carNames = InputView.readCarNames()
    val cars = carNames.map { Car(it) }

    val roundCount = InputView.readRoundCount()

    val game = RacingGame(cars)

    ResultView.printResultHeader()

    repeat(roundCount) {
        cars.forEach { it.move(Randoms.pickNumberInRange(0, 9)) }
        ResultView.printRound(cars)
    }

    val winners = game.findWinners()
    ResultView.printWinners(winners)
}
