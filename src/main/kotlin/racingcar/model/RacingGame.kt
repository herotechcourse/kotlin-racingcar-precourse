package racingcar.model

import racingcar.model.Car
import camp.nextstep.edu.missionutils.Randoms

class RacingGame(private val cars: List<Car>, private val totalRounds: Int) {
    private var currentRound = 0

    fun playRound() {

        for (car in cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
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
}
