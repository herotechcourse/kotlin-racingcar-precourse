package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import kotlin.collections.maxOf

class Race(private val cars: List<Car>) {
    fun play(rounds: Int): List<List<Car>> {
        val history = mutableListOf<List<Car>>()
        repeat(rounds) {
            playOneRound()
            history.add(cars.toList())
        }
        return history
    }

    private fun playOneRound() {
        cars.forEach { car ->
            val number = generateRandomNumber()
            car.move(number)
        }
    }

    private fun generateRandomNumber(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }

    fun findWinners(): List<String> {
        val maxPosition = findMaxPosition()
        return findCarsWithPosition(maxPosition)
    }

    private fun findMaxPosition(): Int {
        return cars.maxOf { it.position }
    }

    private fun findCarsWithPosition(position: Int): List<String> {
        return cars.filter { it.position == position }
            .map { it.name }
    }
}