package racingcar.util

import racingcar.model.Car

object WinnerFinder {
    fun findWinners(cars: List<Car>): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}