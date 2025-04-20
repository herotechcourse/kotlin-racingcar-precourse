package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Race(private val cars: List<Car>, private val rounds: Int) {
    fun start() {
        repeat(rounds) {
            println("\nRound ${it + 1}")
            executeRound()
            displayRaceProgress()
        }
        announceWinners()
    }

    private fun executeRound() {
        cars.forEach { car -> car.move(randomNumberGenerator()) }
    }

    private fun displayRaceProgress() {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
    }

    private fun announceWinners() {
        println("\nFinal Result")
        val maxPosition = cars.maxOf { car -> car.position }
        val winners = cars.filter { it.position == maxPosition }
        println("Winners : ${winners.joinToString(", ") { car -> car.name }}")
    }

    private fun randomNumberGenerator(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }
}