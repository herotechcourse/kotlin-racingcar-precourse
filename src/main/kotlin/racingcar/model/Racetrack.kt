package racingcar.model

import racingcar.model.random.RandomNumberGenerator

class Racetrack(
    private val cars: List<Car>,
    private val randomNumberGenerator: RandomNumberGenerator,
) {
    fun generateRandomNumber(): Int {
        return randomNumberGenerator.generate()
    }

    fun moveCar() {
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
