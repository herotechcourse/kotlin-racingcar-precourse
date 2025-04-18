package racingcar.domain

object Winner {
    fun findWinner(cars: List<Car>): List<String> {
        val maxPosition = cars.maxOfOrNull { it.getPosition() } ?: return emptyList()
        return cars
            .filter { it.getPosition() == maxPosition }
            .map { it.getName() }
    }
}