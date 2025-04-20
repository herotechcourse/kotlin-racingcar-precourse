package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingGame(private val cars: List<Car>) {

    fun playRound() {
        cars.forEach { car ->
            val number = Randoms.pickNumberInRange(0, 9)
            car.move(number)
        }
    }

    fun getCars(): List<Car> = cars
}
