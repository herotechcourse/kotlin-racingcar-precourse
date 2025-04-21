package racingcar.model

class RacingCars(private val cars: List<Car>) {

    fun raceOneRound(moveDecider: () -> Boolean) {
        cars.forEach {it.move(moveDecider()) }
    }

    fun getAllCars(): List<Car> = cars

    fun findWinners(): List<Car> {
        val maxPosition = cars.maxOfOrNull { it.position } ?: 0
        return cars.filter { it.position == maxPosition }
    }
}