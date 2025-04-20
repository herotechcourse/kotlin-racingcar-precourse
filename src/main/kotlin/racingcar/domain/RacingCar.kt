package racingcar.domain

import racingcar.model.Car

class RacingCar {
    private val cars: MutableList<Car> = mutableListOf()

    val allCars: List<Car>
        get() = cars.toList()

    fun addCar(car: Car) {
        cars.add(car)
    }

    fun moveCars() {
        cars.forEach { it.move() }
    }
}
