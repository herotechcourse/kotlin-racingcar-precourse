package racingcar

class Race(private val cars: List<Car>) {
    fun runRound(randomProvider: () -> Int) {
        cars.forEach { car ->
            car.move(randomProvider() >= 4)
        }
    }

    fun getWinners(): List<String> {
        val maxPosition = cars.maxOfOrNull { it.position } ?: 0
        return cars.filter { it.position == maxPosition }.map { it.name }
    }

    fun printProgress() {
        cars.forEach { println(it) }
        println()
    }
}