package racingcar

import racingcar.randomNumber.RandomNumber
import racingcar.randomNumber.RandomNumberImpl

/**
 * @packageName    : racingcar
 * @fileName       : RacingService
 * @author         : yong
 * @date           : 4/17/25
 * @description    :
 */
class RacingService(
    private val cars: List<Car>,
    private val numberGenerator: List<List<Int>>
) {

    val raceResultMap = mutableMapOf<String, MutableList<String>>()

    fun play(): Pair<MutableMap<String, MutableList<String>>, String> {

        for (round in numberGenerator) {
            moveCarForward(round)
        }

        val maxPosition = cars.maxOf { it.getPositionBar() }
        val winners: String = decideWinners(maxPosition)

        return raceResultMap to winners
    }

    private fun addRoundResult(car: String, position: String) {
        val results = raceResultMap.getOrPut(car) { mutableListOf() }
        results.add(position)
    }

    private fun decideWinners(max: String): String {
        println(max)
        return cars.filter { it.getPositionBar() == max }.joinToString(", ") { it.name }
    }

    private fun moveCarForward(numList: List<Int>) {
        for (i in 0 until numList.size) {
            cars[i].move(numList[i])
            addRoundResult(cars[i].name, cars[i].getPositionBar())
        }
    }
}