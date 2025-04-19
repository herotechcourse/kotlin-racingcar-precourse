package racingcar

import camp.nextstep.edu.missionutils.Randoms

/**
 * @packageName    : racingcar
 * @fileName       : RacingService
 * @author         : yong
 * @date           : 4/17/25
 * @description    :
 */
class RacingService(val names: List<String>, val round: Int) {
    private val cars: List<Car> = names.map { Car(it) }
    val raceResultMap = mutableMapOf<String, MutableList<String>>()

    fun addRoundResult(car: String, position: String) {
        val results = raceResultMap.getOrPut(car) { mutableListOf() }
        results.add(position)
    }

    fun play(): Pair<MutableMap<String, MutableList<String>>, String> {
        println("Race Results")
        repeat(round) {
            val nums: List<Int> = getRandomNumber(cars.size)
            moveCarForward(nums)
        }

        val maxPosition = cars.maxOf { it.getPositionBar() }
        val winners: String = decideWinners(maxPosition)

        return raceResultMap to winners
    }

    fun decideWinners(max: String): String {
        println(max)
        return cars.filter { it.getPositionBar() == max }.joinToString(", ") { it.name }
    }

    fun getRaceResultString(): String {
        return cars.joinToString("\n") { car ->
            "${car.name}: ${car.getPositionBar()}"
        }
    }

    fun moveCarForward(numList: List<Int>) {
        for (i in 0 until numList.size) {
            cars[i].move(numList[i])
            addRoundResult(cars[i].name, cars[i].getPositionBar())
        }
    }

    fun getRandomNumber(carsCount: Int): List<Int> {
        return List(carsCount) {
            Randoms.pickNumberInRange(0, 9)
        }
    }
}