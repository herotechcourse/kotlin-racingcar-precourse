package racingcar

class Lap(private val cars: List<Car>) {
    fun runLap() {
        cars.forEach { it.moveForward() }
    }

    fun displayPositions() {
        cars.forEach { it.displayPosition() }
        println()
    }
}