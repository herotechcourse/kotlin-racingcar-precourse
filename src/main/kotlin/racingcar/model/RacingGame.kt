package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class RacingGame(val cars: List<Car>, val rounds: Int) {

    fun play() {
        repeat(rounds) {
            moveCars()
        }
    }

    private fun moveCars() {
        cars.forEach { car ->
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            car.move(randomNumber >= 4)
        }
    }
}