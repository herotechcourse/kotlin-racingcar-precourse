package racingcar
import camp.nextstep.edu.missionutils.Randoms

class Race(
    private val cars: List<Car>,
    private val rounds: Int
) {
    fun printResult() {
        println("Winners : ${getWinnersNames().joinToString(", ")}")
    }

    fun runRace() {
        repeat(rounds) {
            runRound()
            printProgress()
        }
    }

    private fun runRound() {
        cars.forEach { car ->
            if (Randoms.pickNumberInRange(0, 9) >= 4) car.move()
        }
    }

    private fun printProgress() {
        cars.forEach { println(it) }
        println()
    }

    private fun getWinnersNames(): List<String> {
        val maxPosition = cars.maxOfOrNull { it.position } ?: 0
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}