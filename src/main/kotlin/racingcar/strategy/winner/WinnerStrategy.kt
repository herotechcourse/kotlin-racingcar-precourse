package racingcar.strategy.winner

import racingcar.model.Car

fun interface WinnerStrategy {
    fun selectWinners(cars: List<Car>): List<Car>
}