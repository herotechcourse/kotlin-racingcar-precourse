package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Race(private val cars: List<Car>, private val rounds: Int) {

    private val positions: MutableList<Int> = MutableList(cars.size) { 0 }

    companion object {
        const val MOVING_FORWARD: Int = 4
        const val STOP: Int = 3
    }

    fun getPositions(): List<Int> {
        return positions
    }

    fun runTheRace() {
        repeat(rounds) {
            moveCarsIfEligible()
        }
    }

    fun getWinners(): List<Car> {
        val maxPosition = positions.maxOrNull() ?: 0
        return cars.filterIndexed { index, _ -> positions[index] == maxPosition }
    }

    private fun moveCarsIfEligible() {
        for (index in positions.indices) {
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            if (randomNumber >= Race.MOVING_FORWARD) {
                positions[index] += 1
            }
        }
    }
}