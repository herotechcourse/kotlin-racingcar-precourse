package racingcar

class Game(
    private val cars: List<Car>,
    private val rounds: Int
) {

    fun start() {
        println("Race results:")
        for (round in 1..rounds) {
            cars.forEach { it.moveCar() }
            displayProgress()
        }
    }

    private fun displayProgress() {
        OutputFormatter.formatResults(cars)
    }

    fun getWinner(): List<Car> {
        val maxPosition = cars.maxOf { it.getPosition() }
        return cars.filter { it.getPosition() == maxPosition }
    }
}
