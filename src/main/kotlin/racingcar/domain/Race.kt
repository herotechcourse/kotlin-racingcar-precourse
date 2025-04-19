package racingcar.domain

import Car

class Race(val cars: List<Car>) {
    constructor(names: List<String>) : this(names.map { Car(it) })

    fun moveAll() {
        cars.forEach { it.moveIfPossible() }
    }

    fun findWinners(): List<String> {
        val max = cars.maxOf { it.position }
        return cars.filter { it.position == max }.map { it.name }
    }
}
