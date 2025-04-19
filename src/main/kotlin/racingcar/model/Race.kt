package racingcar.model

import racingcar.service.Formatter

class Race(
    private val cars: List<Car>,
    private val rounds: Int
) {

    fun run() {
        repeat(rounds) {
            runRound()
            println()
        }
    }

    fun findWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }

    private fun runRound() {
        for (car in cars) {
            car.move()
            println(Formatter.currentPosition(car))
        }
    }
}
