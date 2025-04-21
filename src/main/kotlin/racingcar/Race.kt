package racingcar

import racingcar.model.RaceInputs
import racingcar.model.Car
import camp.nextstep.edu.missionutils.Randoms

class Race(raceInputs: RaceInputs) {
    val names: List<String> = raceInputs.cars
    val endRound: Int = raceInputs.round

    fun run() {
        val cars = createCarObj(names)

        println()
        println("Race Results")
        race(cars)
    }

    fun race(cars: List<Car>) {
        var round = 0

        while (round < endRound) {
            for(car in cars) {
                decideGoStop(car)
                printRoundResult(car)
            }
            println()
            round++
        }
        println("Winners : ${getWinners(cars)}")
    }

    private fun getWinners(cars: List<Car>): String {
        val maxPosition = cars.maxOfOrNull { it.position }

        return if (maxPosition != null) {
            cars.filter { it.position == maxPosition }.map { it.name }.joinToString(", ")
        } else {
           "No One"
        }
    }

    private fun printRoundResult (car: Car) {
        val character = "-"
        println("${car.name} : ${character.repeat(car.position)}")
    }

    private fun decideGoStop(car: Car) {
        val random = Randoms.pickNumberInRange(0, 9)
        if (random >= 4) car.moveForward()
    }

    internal fun createCarObj(names:List<String>): List<Car> {
        return names.map {Car(it, 0)}
    }
}