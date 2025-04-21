package racingcar.domain

import racingcar.model.Car
import racingcar.observer.IRaceObserver
import racingcar.strategy.MovementStrategy

/**
 * Coordinates the race execution and progression.
 *
 * @property cars list of participating cars
 * @property strategy strategy used for movement
 * @property observer responsible for notifying listeners
 */
class Race(
    private val cars: List<Car>,
    private val rounds: Int,
    private val strategy: MovementStrategy,
    private val observer: IRaceObserver
) {
    /**
     * Runs the race simulation and announces winners.
     */
    fun start() {
        repeat(rounds) { round ->
            cars.forEach { it.move(strategy) }
            observer.notifyRound(round + 1, cars)
        }

        val max = cars.maxOf { it.position }
        val winners = cars.filter { it.position == max }.map { it.name }
        observer.notifyFinish(cars, winners)
    }
}
