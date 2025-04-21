package racingcar.controller

import racingcar.model.Car

class GameState(
    private val cars: List<Car>,
) {
    fun getWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}
