package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingGame(
    carNames: List<String>,
    private val rounds: Int,
    private val outputHandler: OutputHandler
) {

    private val cars = carNames.map { Car(it) }

    fun run() {
        outputHandler.printRaceStart()
        playGame(cars, rounds)
    }

    private fun playGame(cars: List<Car>, rounds: Int) {
        repeat(rounds) {
            cars.forEach { it.attemptMove(Randoms.pickNumberInRange(0, 9) >= 4) }
            outputHandler.printRaceResult(cars)
        }
        outputHandler.printWinners(cars)
    }
}