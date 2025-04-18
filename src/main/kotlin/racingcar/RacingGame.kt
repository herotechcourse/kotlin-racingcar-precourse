package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.view.ResultView.printRoundResult
import kotlin.math.max

class RacingGame(private val carNames: List<String>) {
    private val cars: List<Car> = carNames.map { Car(it) }

    fun play(rounds: Int) {
        var winnerString = ""
        repeat(rounds) {
            cars.forEach {
                it.move()
            }
            printRoundResult(cars)
        }
        winnerString = determineWinner(cars).joinToString(", ")
        println("Winners : $winnerString")
    }

    fun determineWinner(cars: List<Car>): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}
