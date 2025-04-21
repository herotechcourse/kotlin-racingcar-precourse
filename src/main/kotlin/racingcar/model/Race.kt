package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import kotlin.collections.maxOf

class Race(private val cars: List<Car>) {
    fun play(rounds: Int): List<List<Car>> {
        val history = mutableListOf<List<Car>>()

        repeat(rounds) {
            cars.forEach { car ->
                val number = Randoms.pickNumberInRange(0, 9)
                car.move(number)
            }
            history.add(cars.toList())
        }
        return history
    }

    fun findWinners(): List<String> {
        val max = cars.maxOf { car -> car.position }
        return cars.filter { car -> car.position == max }.map { car -> car.name }
    }
}