package racingcar.model

import racingcar.model.random.RandomNumberGenerator

class RacingGame(
    private val cars: List<Car>,
    private val randomNumberGenerator: RandomNumberGenerator,
) {
    fun generateRandomNumber(): Int {
        return randomNumberGenerator.generate()
    }

    fun moveCars() {
        cars.forEach { car ->
            val randomNumber = generateRandomNumber()
            car.move(randomNumber)
        }
    }

    fun decideWinner(): List<Car> {
        val winnersPosition = cars.maxOf { it.position }
        return cars.filter { it.position == winnersPosition }
    }
}
