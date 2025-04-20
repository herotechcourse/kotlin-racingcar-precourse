package racingcar

fun findWinners(cars: List<Car>): List<Car> {
    val maxDistance = cars.maxOfOrNull { it.distance }
    return cars.filter { it.distance == maxDistance }
}