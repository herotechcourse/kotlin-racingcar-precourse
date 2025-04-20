package racingcar.model

import racingcar.service.RandomService
import kotlin.math.max

class Race(val cars: List<Car>, val rounds: Int) {
    private var currentRound: Int = 0
    private var randomService = RandomService()

    fun playRound() {
        if(isFinished()){
            throw IllegalStateException("Race is already finished")
        }
        cars.forEach{ car ->
            car.move(randomService.generateMoveValue())
        }
        currentRound++
    }

    fun isFinished(): Boolean {
        return currentRound >= rounds
    }

    fun findWinners(): List<Car> {
        val maxPosition = cars.maxOfOrNull { it.getPosition() } ?: 0
        return cars.filter {it.getPosition() == maxPosition }
    }
}