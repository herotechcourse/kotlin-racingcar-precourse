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
    private val output = Output()

    fun play() {
        println("Race Results")
        for (i in 0 until round) {
            val nums: List<Int> = getRandomNumber(3)
            moveCarForward(nums)
            val roundRaceResult = getRaceResultString()
            output.displayRaceResults(roundRaceResult)
        }
        val maxPosition = cars.maxOf { it.getPositionBar() }
        val winners: String = decideWinners(maxPosition)
        output.displayWinners(winners)
    }

    fun decideWinners(max : String): String {
        println(max)
        return cars.filter { it.getPositionBar() == max }.joinToString(", ") {it.name}
    }

    fun getRaceResultString(): String {
        return cars.joinToString("\n") { car ->
            "${car.name}: ${car.getPositionBar()}"
        }
    }

    fun moveCarForward(numList: List<Int>) {
        for(i in 0 until numList.size) {
            cars[i].move(numList[i])
        }
    }

    fun getRandomNumber(carsCount: Int): List<Int> {
        return List(carsCount){
            Randoms.pickNumberInRange(0, 9)
        }
    }
}