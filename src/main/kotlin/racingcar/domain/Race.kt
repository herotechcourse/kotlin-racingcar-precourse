package racingcar.domain

import racingcar.dto.CarSnapshot
import racingcar.utils.RandomUtil

class Race(private val cars: List<Car>, private val rounds: Int) {

    fun start(): List<List<CarSnapshot>> {
        val roundResults = mutableListOf<List<CarSnapshot>>()

        repeat(rounds) {
            playOneRound()

            val snapshot = cars.map { car -> CarSnapshot(car.name, car.getPosition()) }
            roundResults.add(snapshot)
        }

        return roundResults
    }

    private fun playOneRound() {
        cars.forEach { car ->
            if (RandomUtil.generate() >= 4) car.moveForward()
        }
    }

    fun getWinners(): List<String> {
        val maxPosition = cars.maxOf { it.getPosition() }
        return cars.filter { it.getPosition() == maxPosition }.map { it.name }
    }

}