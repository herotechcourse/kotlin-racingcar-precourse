package racingcar.model

import racingcar.model.Car
import camp.nextstep.edu.missionutils.Randoms

class RacingGame(private val cars: List<Car>, private val totalRounds: Int) {
    private var currentRound = 0

    init {
        require(cars.isNotEmpty()) { "At least one car is required" }
        require(totalRounds > 0) { "Number of rounds must be positive" }
    }

    fun playRound() {
      if (isGameOver()) {
            return
        }

        cars.forEach { car ->
            if (shouldMove(car)) {
                car.move()
            }
        }

        currentRound++
    }

    fun getWinners(): List<Car> {
        val maxPosition = cars.maxOfOrNull { it.getPosition() } ?: 0
        return cars.filter { it.getPosition() == maxPosition }
    }

    fun isGameOver(): Boolean = currentRound >= totalRounds

    fun getCars(): List<Car> = cars

    private fun shouldMove(): Boolean = Randoms.pickNumberInRange(0, 9) >= 4
}
