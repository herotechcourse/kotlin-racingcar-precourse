package racingcar.model

class Race(carNames: List<String>) {
    val cars: List<Car> = carNames.map { Car(it) }

    fun moveAllCars() {
        cars.forEach { it.move() }
    }

    fun findWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }
}
