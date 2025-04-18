package racingcar.domain

class Cars(private val cars: List<Car>) {
    fun getPositions(): List<Pair<String, Int>> {
        return cars.map { it.name to it.position }
    }

    fun findWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
            .map { it.name }
    }
}