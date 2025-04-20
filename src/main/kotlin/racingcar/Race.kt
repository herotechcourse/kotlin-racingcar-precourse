package racingcar

class Race(private val cars: List<Car>, private val totalLaps: Int) {
    fun start() {
        repeat(totalLaps) {
            val lap = Lap(cars)
            lap.runLap()
            lap.displayPositions()
        }
    }

    fun displayWinners() {
        val highestPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == highestPosition }
        println("Winners : ${winners.joinToString(", ") { it.name }}")
    }
}