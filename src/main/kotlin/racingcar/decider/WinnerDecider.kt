package racingcar.decider

import racingcar.domain.Car

class WinnerDecider {
    fun decide(cars: List<Car>): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}