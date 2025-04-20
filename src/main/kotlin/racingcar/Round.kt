package racingcar

class Round {

    fun getWinners(cars: Set<Car>): List<Car> {
        val maxMovementCount = getMaxMovementCount(cars)
        return cars.filter { it.movementCount == maxMovementCount }
    }

    private fun getMaxMovementCount(cars: Set<Car>) = cars.maxOf { it.movementCount }
}
