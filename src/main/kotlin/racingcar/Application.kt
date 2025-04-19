package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val game = RacingGame()
    game.play()
}

class RacingGame {
    companion object {
        private const val MAX_NAME_LENGTH = 5
        private const val MOVE_FORWARD = 4
    }

    fun play() {
        val cars = inputCars()
        val rounds = inputRounds()
        val positions = race(cars, rounds)
        printWinners(cars, positions)
    }
}
