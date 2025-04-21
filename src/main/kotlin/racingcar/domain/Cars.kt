package racingcar.domain

class Cars(carNames: List<String>) {
    private val cars: List<Car> = carNames.map { Car(it) }

    fun moveAll() {
        cars.forEach { it.move() }
    }

    fun getWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }

    fun printAllPositions() {
        cars.forEach { println("${it.name}: ${it.getPositionDisplay()}") }
    }
}
