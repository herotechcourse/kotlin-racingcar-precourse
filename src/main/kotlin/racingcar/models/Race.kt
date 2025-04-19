package racingcar.models

import camp.nextstep.edu.missionutils.Randoms

class Race(carNames: List<String>) {
    private val cars: List<Car> = carNames.map { Car(it) }

    fun runRound() {
        cars.forEach { it.move(Randoms.pickNumberInRange(0, 9)) }
    }

    fun printStatus() {
        cars.forEach { println(it.status()) }
        println()
    }

    fun findWinners(): List<String> {
        val max = cars.maxOf { it.getPosition() }
        return cars.filter { it.getPosition() == max }.map { it.name }
    }
    fun getCars(): List<Car> = cars

}