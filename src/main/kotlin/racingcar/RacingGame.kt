package racingcar

// RacingGame class - handles the core game logic
class RacingGame(names: List<String>) {

    // Create a list of Car objects from the given names (whitespace is trimmed)
    val cars: List<Car> = names.map { Car(it.trim()) }

    // Move all cars once by applying the move logic
    fun move() {
        cars.forEach { it.move() }
    }

    // Find the car(s) with the highest position and return their names
    fun findWinners(): List<String> {

        // Determine the farthest distance any car has moved
        val maxPosition = cars.maxOf { it.position }

        // Filter cars that are at the max position and return their names
        return cars.filter { it.isAt(maxPosition) }.map { it.name }

    }

}