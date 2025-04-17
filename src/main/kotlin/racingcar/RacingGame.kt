package racingcar

import racingcar.generator.RandomNumberGenerator

class RacingGame(val cars: List<Car>, val round: Int) {

    fun startGame(randomGenerator: RandomNumberGenerator) {
        repeat(round) {
            playOneRound(randomGenerator)
        }
    }

    fun findWinner() : List<Car> {
        val max = cars.maxOf { car -> car.position }
        return cars.filter { car -> car.position == max }
    }

    private fun playOneRound(randomGenerator: RandomNumberGenerator) {
        for (car in cars) {
            car.move(randomGenerator)
        }
    }

}