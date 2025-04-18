package racingcar

import racingcar.generator.RandomNumberGenerator

class RacingGame(val cars: List<Car>) {

    fun startGame(randomGenerator: RandomNumberGenerator) {
        for (car in cars) {
            car.move(randomGenerator)
        }
    }

    fun findWinner() : List<Car> {
        val max = cars.maxOf { car -> car.position }
        return cars.filter { car -> car.position == max }
    }

}