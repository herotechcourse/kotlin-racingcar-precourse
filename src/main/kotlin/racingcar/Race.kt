package racingcar

class Race(private val cars: List<Car>, private val rounds: Int) {

    fun start() {
        repeat(rounds) {
            moveAll()
            printStatus()
        }
    }

    fun winners(): List<String> {
        val max = cars.maxOf { it.position }
        return cars.filter { it.position == max }.map { it.name }
    }

    private fun moveAll() {
        cars.forEach { it.move() }
    }

    private fun printStatus() {
        cars.forEach { println(it.display()) }
        println()
    }
}
