package racingcar

class Race(private val cars: List<Car>, private val rounds: Int) {

    fun start() {
        println("\nRace Results")
        repeat(rounds) {
            cars.forEach { car ->
                car.move()
                println(car.progress())
            }
            println()
        }
        announceWinners()
    }

    private fun announceWinners() {
        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }
            .joinToString(", ") { it.name }

        println("Winners : $winners")
    }
}
