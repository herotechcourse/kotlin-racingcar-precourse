package racingcar.observer

import racingcar.model.Car

/**
 * Manages race listeners and notifies them during race progress.
 */
class RaceObserver(private val listeners: List<RaceListener>) {

    fun notifyRound(round: Int, cars: List<Car>) {
        listeners.forEach { it.onRound(round, cars) }
    }

    fun notifyFinish(cars: List<Car>, winners: List<String>) {
        listeners.forEach { it.onFinish(cars, winners) }
    }
}
