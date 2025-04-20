package racingcar

class Round {

    fun getWinners(cars: Set<Car>): List<Car> {
        val maxMovementCount = cars.maxOf { it.movementCount }
        return cars.filter { it.movementCount == maxMovementCount }
    }
}
