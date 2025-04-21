package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class Race(private val cars: List<Car>, private val rounds: Int) {
    fun run(): List<Car> {
        repeat(rounds) {
            executeRound()
        }
        return determineWinners()
    }

    fun executeRound() {
        cars.forEach { car ->
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            car.move(randomNumber)
        }
    }

    fun determineWinners(): List<Car> {
        val maxPosition = cars.maxOfOrNull { it.getPosition() } ?: 0
        return cars.filter { it.getPosition() == maxPosition }
    }
}