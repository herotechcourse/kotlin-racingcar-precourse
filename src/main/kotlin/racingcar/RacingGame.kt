package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.view.ResultView.printRoundResult

class RacingGame(private val carNames: List<String>) {
    private val cars: List<Car> = carNames.map { Car(it) }

    fun play(rounds: Int) {
        repeat(rounds) {
            cars.forEach {
                it.move()
            }
            printRoundResult(cars)
        }
    }
}
