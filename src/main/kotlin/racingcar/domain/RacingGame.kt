package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class RacingGame(private val cars: List<Car>) {

    fun play(rounds: Int, numberGenerator: () -> Int): List<List<Pair<String, Int>>> {
        val result = mutableListOf<List<Pair<String, Int>>>()

        repeat(rounds) {
            cars.forEach { it.move(numberGenerator()) }
            result.add(cars.map { it.getName() to it.position })
        }
        return result
    }

    fun findWinners(): List<String> {
        val max = cars.maxOf { it.position }
        return cars.filter { it.position == max }.map { it.getName() }
    }
}