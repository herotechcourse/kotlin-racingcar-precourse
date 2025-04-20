package racingcar.model

class Cars(private val cars: List<Car>) {
    fun moveAll() {
        cars.forEach { it.tryMove() }
    }

    fun snapshot(): List<Car> = cars.map { it.copy() }

    fun findWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars
            .filter { it.position == maxPosition }
            .map { it.name }
    }
}