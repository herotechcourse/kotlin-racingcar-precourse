package racingcar.strategy.winner

import racingcar.model.Car

class MaxPositionStrategy : WinnerStrategy {
    override fun selectWinners(cars: List<Car>): List<Car> {
        val max = cars.maxOf{ it.position() }
        return cars.filter { it.position() == max }
    }
}