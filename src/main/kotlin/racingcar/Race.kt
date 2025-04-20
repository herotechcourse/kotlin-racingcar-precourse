package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Race(
    private val cars: List<Car>, 
    private val rounds: Int,
    private val raceDisplay: RaceDisplay
) {
    fun start() {
        repeat(rounds) {
            println("\nRound ${it + 1}")
            executeRound()
            displayRaceProgress()
        }
        announceWinners()
    }

    private fun executeRound() {
        cars.forEach { car: Car -> car.move(randomNumberGenerator()) }
    }

    private fun displayRaceProgress() {
        cars.forEach { car: Car -> raceDisplay.showCarProgress(car) }
    }

    private fun announceWinners() {
        val maxPosition = cars.maxOf { car: Car -> car.position }
        val winners = cars.filter { car: Car -> car.position == maxPosition }
        raceDisplay.showWinners(winners)
    }

    private fun randomNumberGenerator(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }
}