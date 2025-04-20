package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Race(private val cars: List<Car>, private val rounds: Int) {

    companion object {
        const val MOVING_FORWARD: Int = 4
        const val STOP: Int = 3
    }

    fun runTheRace() {
        repeat(rounds) {
            moveCarsIfEligible()
        }
    }

    fun getWinners(): List<Car> {
        val maxScore = cars.maxOf { it.roundPoints }
        return cars.filter { it.roundPoints == maxScore }
    }

    private fun moveCarsIfEligible() {
        cars.forEach { car ->
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            if (randomNumber >= Race.MOVING_FORWARD) {
                car.roundPoints += 1
            }
        }
    }
}