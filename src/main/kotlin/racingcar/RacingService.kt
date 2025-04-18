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

    fun play() {
        println("Race Results")
        for (i in 0 until round) {
            cars.forEach { car ->
                car.move(getRandomNumberForMovement())
            }
            OutPut().displayRaceResults(cars)
        }
    }

    fun getRandomNumberForMovement(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }
}