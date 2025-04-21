package racingcar.domain

import racingcar.utils.RandomUtil

class Race(private val cars: List<Car>, private val rounds: Int) {

    private fun playOneRound() {
        cars.forEach { car ->
            if (RandomUtil.generate() >= 4) car.moveForward()
        }
    }

}