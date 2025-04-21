package racingcar

import camp.nextstep.edu.missionutils.Randoms

object GameLogic {
    private const val MOVE_THRESHOLD: Int = 4

    private fun checkMove(): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= MOVE_THRESHOLD
    }

    private fun moveCar(car: Car) {
        if (checkMove()) {
            car.position++
        }
    }

    fun startRace(cars: List<Car>, rounds: Int) {
        println("Race Results")

        repeat(rounds) {
            cars.forEach { car ->
                moveCar(car)
            }
            OutputHandler.printRoundResults(cars)
        }
    }
}