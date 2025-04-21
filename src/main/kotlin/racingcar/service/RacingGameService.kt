package racingcar.service

import camp.nextstep.edu.missionutils.Randoms
import racingcar.domain.Car
import racingcar.view.CarView

class RacingGameService(
    private val cars: List<Car>,
    private val numberGenerator: () -> Int = { Randoms.pickNumberInRange(0, 9) }
) {
    fun play(rounds: Int): List<List<Car>> {
        val results = mutableListOf<List<Car>>()

        repeat(rounds) {
            cars.forEach { it.move(numberGenerator()) }
            results.add(cars.map { it.copy() })
        }

        return results
    }

    fun getCurrentCarViews(): List<CarView> = cars.map { it.toView() }

    fun getWinners(): List<String> {
        val max = cars.maxOf { it.position }
        return cars.filter { it.position == max }.map { it.getName() }
    }
}
