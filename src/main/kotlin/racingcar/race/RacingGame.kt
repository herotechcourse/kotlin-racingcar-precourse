package racingcar.race

import racingcar.car.Car
import racingcar.strategy.MoveStrategy

class RacingGame(
    private val cars: List<Car>,
    private val rounds: Int,
    private val strategy: MoveStrategy
) {
    fun race() {
        repeat(rounds) {
            cars.forEach { it.move(strategy) }
            printProgress()
        }
    }

    fun winners(): List<Car> {
        val best = cars.maxOf { it.position() }
        return cars.filter { it.position() == best }
    }

    private fun printProgress() {
        cars.forEach { println("${it.name} : ${"-".repeat(it.position())}") }
        println()
    }
}
