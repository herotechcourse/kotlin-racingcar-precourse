package racingcar

import racingcar.generator.RandomNumberGenerator

class MockRacingGame(val cars: List<Car>) {

    var moveCallCount = 0
        private set

    fun startGame(randomGenerator: RandomNumberGenerator) {
        for (car in cars) {
            car.move(randomGenerator)
            moveCallCount++
        }
    }

    fun findWinner() : List<Car> {
        val max = cars.maxOf { car -> car.position }
        return cars.filter { car -> car.position == max }
    }

}