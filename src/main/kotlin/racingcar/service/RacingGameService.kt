package racingcar.service

import camp.nextstep.edu.missionutils.Randoms
import racingcar.domain.Car
import racingcar.domain.RacingGame

class RacingGameService(
    private val cars: List<Car>
) {
    private val game = RacingGame(cars)

    fun play(rounds: Int, numberGenerator: () -> Int = { Randoms.pickNumberInRange(0, 9) }): List<List<Car>> {
        val results = mutableListOf<List<Car>>()

        repeat(rounds) {
            cars.forEach { it.move(numberGenerator()) }
            results.add(cars.map { it.copy() })
        }

        return results
    }
    fun getWinners(): List<String> {
        return game.findWinners()
    }
}
