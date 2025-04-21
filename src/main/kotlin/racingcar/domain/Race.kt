package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms
import racingcar.view.OutputManager

class Race(carNames: List<String>) {
    private val cars: List<Car> = carNames.map { Car(it) }

    private fun generateRandomNumber(): Int {
        return Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX)
    }

    private fun moveCars() {
        cars.forEach { car -> car.move(generateRandomNumber()) }
    }

    private fun findWinners(): List<String> {
        val maxPosition = cars.maxOfOrNull { it.position } ?: 0

        return cars.filter { it.position == maxPosition }
            .map { it.name }
    }

    fun run(tries: Int) {
        println("\nRace Results")
        repeat(tries) {
            moveCars()
            OutputManager.printRaceStatus(cars)
            println()
        }
        OutputManager.printWinners(findWinners())
    }
}