package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Race(private val cars: List<Car>, private val rounds: Int) {

    fun start() {
        println("\nRace Results")
        repeat(rounds) {
            playOneRound()
            displayRaceProgress()
        }

        displayWinners()
    }

    private fun playOneRound() {
        cars.forEach { car ->
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            car.move(randomNumber >= 4)
        }
    }

    private fun displayRaceProgress() {
        cars.forEach { car ->
            println("${car.name} : ${car.getPositionDisplay()}")
        }

        println()
    }

    private fun findWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }

    }

    private fun displayWinners() {
        val winners = findWinners()
        val winnerNames = winners.joinToString(", ") { it.name }
        println("Winners : $winnerNames")
    }

}