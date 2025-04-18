package racingcar

/**
 * @packageName    : racingcar
 * @fileName       : OutPut
 * @author         : yong
 * @date           : 4/18/25
 * @description    :
 */
class OutPut {
    fun displayRaceResults(cars: List<Car>) {
        cars.forEach {car ->
            println("${car.name}: ${car.getPositionBar()}")
        }
        println()
    }
}