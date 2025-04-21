package racingcar.model

import racingcar.model.Car
import camp.nextstep.edu.missionutils.Randoms
import racingcar.io.OutputHandler

class RacingGame(private val cars: List<Car>, private val totalRounds: Int) {
    private var currentRound = 0

    fun startRace() {
        OutputHandler().printRaceResults(cars)

        while (currentRound < totalRounds) {
            for (car in cars) {
                if (Randoms.pickNumberInRange(0, 9) >= 4) {
                    car.move()
                }
            }

            OutputHandler().printRoundResults(cars)

            currentRound++
        }

        OutputHandler().printWinners(getWinners())
    }

    fun getWinners(): List<Car> {
        val maxPosition = cars.maxOfOrNull { it.getPosition() } ?: 0
        return cars.filter { it.getPosition() == maxPosition }
    }
}
