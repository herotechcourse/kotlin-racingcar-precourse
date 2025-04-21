package racingcar.model

class RacingCars private constructor(
    private val cars: List<RacingCar>,
    private val generator: RandomNumberGenerator
) {

    companion object {
        fun fromNames(names: List<String>): RacingCars {
            val cars = names.map { RacingCar(it) }
            return RacingCars(cars, Range0to9RandomGenerator())
        }
    }

    fun moveAll() {
        cars.forEach { it.moveForwardIfPossible(generator.generate()) }
    }

    fun findWinners(): List<String> {
        val maxPosition = cars.maxOf { it.progress }
        return cars
            .filter { it.progress == maxPosition }
            .map { it.name }
    }

    fun all(): List<RacingCar> = cars
}
