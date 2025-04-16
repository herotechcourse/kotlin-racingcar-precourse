package racingcar.domain

import kotlin.math.max

class Cars(val cars: List<Car>) {
    init {
        validateUniqueNames()
    }

    private fun validateUniqueNames() {
        val names = cars.map { it.name }
        if (names.size != names.toSet().size) {
            throw IllegalArgumentException("Car names must be unique.")
        }
    }

    fun move() {
        for (car in cars) {
            car.move()
        }
    }

    fun winners(): List<Car> {
        var maxPosition = 0
        for (car in cars) {
            maxPosition = max(maxPosition, car.position)
        }
        return cars.filter { car -> car.position == maxPosition }.toList()
    }
}
