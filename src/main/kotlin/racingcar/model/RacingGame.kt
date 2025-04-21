package racingcar.model

import racingcar.model.Car
import camp.nextstep.edu.missionutils.Randoms

class RacingGame(private val cars: List<Car>, private val totalRounds: Int) {
    private var currentRound = 0

    fun startRace() {
        println("Race Results")

        while (currentRound < totalRounds) {
            for (car in cars) {
                if (Randoms.pickNumberInRange(0, 9) >= 4) {
                    car.move()
                }
            }

            cars.forEach { car ->
                val position = "-".repeat(car.getPosition())
                println("${car.name} : $position")
            }
            println()

            currentRound++
        }

        announceWinners()
    }

    private fun announceWinners() {
        val maxPosition = cars.maxOf { car -> car.getPosition() }
        val winners = cars.filter { car -> car.getPosition() == maxPosition }
        println("Winners : ${winners.joinToString(", ") { it.name }}")
    }
}
