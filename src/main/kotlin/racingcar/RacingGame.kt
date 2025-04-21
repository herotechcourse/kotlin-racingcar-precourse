package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingGame(private val cars: List<Car>) {
    fun playRound() {
        cars.forEach { car ->
            if (shouldMove()) {
                car.move()
            }
        }
    }

    private fun shouldMove(): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= 4
    }

    fun getWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }

    fun getCurrentState(): String {
        return cars.joinToString("\n") { "${it.name} : ${it.getPositionString()}" }
    }
}