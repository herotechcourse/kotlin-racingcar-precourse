package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingGame(private val cars: List<Car>) {
    fun play(rounds: Int) {
        repeat(rounds) {
            cars.forEach { car ->
                val number = Randoms.pickNumberInRange(0, 9)
                car.move(number)
            }
            printResult()
        }
    }

    private fun printResult() {
        cars.forEach {
            println("${it.getName()} : ${"-".repeat(it.position)}")
        }
        println()
    }

    fun getWinners(): List<String> {
        val max = cars.maxOf { it.position }
        return cars.filter { it.position == max }.map { it.getName() }
    }
}
