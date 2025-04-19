package racingcar
import camp.nextstep.edu.missionutils.Randoms

class Race(private val cars: List<Car>) {
    fun runRound() {
        cars.forEach { car ->
            car.move(Randoms.pickNumberInRange(0, 9) >= 4)
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