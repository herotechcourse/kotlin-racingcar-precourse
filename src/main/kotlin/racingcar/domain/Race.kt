package racingcar.domain

import racingcar.service.movement.MovementStrategy

data class Race(val cars: List<Car>) {
    fun moveAll(strategy: MovementStrategy): Race {
        return Race(cars.map { it.move(strategy) })
    }

    fun winners(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }

    fun display(): List<String> = cars.map { it.display() }
}
