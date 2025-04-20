package racingcar

import racingcar.Car

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
        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }
        println("Winners : ${winners.joinToString(", ") { it.name }}")
    }

    private fun randomNumberGenerator(): Int {
        return (0..9).random()
    }
}