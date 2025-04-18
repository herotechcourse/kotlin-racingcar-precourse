package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.view.printResult
import racingcar.view.printRoundResult
import kotlin.math.max

class RacingGame(private val carNames: List<String>) {
    private val cars: List<Car> = carNames.map { Car(it) }

    fun play(rounds: Int) {
        var winnerString = ""
        repeatRounds(rounds, cars)
        winnerString = determineWinner(cars).joinToString(", ")
        printResult(winnerString)
    }

    fun determineWinner(cars: List<Car>): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}


