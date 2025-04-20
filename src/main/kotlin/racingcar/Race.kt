package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Race(private val cars: List<Car>) {
    fun moveAllCars() {
        cars.forEach { car ->
            car.move(Randoms.pickNumberInRange(0, 9))
        }
    }

    fun printStatus() {
        cars.forEach { car ->
            car.printStatus()
        }
        println()
    }

    fun findWinners(): List<String> {
        val maxPosition = cars.maxOf { it.getPosition() }
        return cars.filter { it.getPosition() == maxPosition }
            .map { it.getName() }
    }
}
