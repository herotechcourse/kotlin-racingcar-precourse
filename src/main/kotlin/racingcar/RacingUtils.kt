package racingcar

/**
 * Decided to move it to the separate function to isolate winner calculation logic.
 */
fun findWinners(cars: List<Car>): List<Car> {
    val maxDistance = cars.maxOfOrNull { it.distance }
    return cars.filter { it.distance == maxDistance }
}
