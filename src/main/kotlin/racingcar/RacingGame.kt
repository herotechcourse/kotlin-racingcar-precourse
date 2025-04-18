package racingcar

// RacingGame class - handles the core game logic
class RacingGame(names: List<String>) {

    // Create a list of Car objects from the given names (whitespace is trimmed)
    val cars: List<Car> = names.map { Car(it.trim()) }

    // Move all cars once by applying the move logic
    fun move() {
        cars.forEach { it.move() }
    }

}