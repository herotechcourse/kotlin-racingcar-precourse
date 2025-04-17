package racingcar

import racingcar.generator.RandomNumberGenerator

class GameService(private val randomGenerator: RandomNumberGenerator) {

    fun playOneRound(cars : List<Car>) {
        for (car in cars) {
            car.move(randomGenerator)
        }
    }

}