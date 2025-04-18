package racingcar.domain

import racingcar.io.Printer

class RaceGame(
    private val cars: List<Car>,
    private val roundNumber : Int,
    private val resultPrinter: Printer
) {
    init {
        require(roundNumber > 0)
    }

    fun raceAllRound() : List<Car> {
        for (i in 1..roundNumber) {
            raceOneRound(cars)
            resultPrinter.printCurrentCarPosition(cars)
        }

        return cars
    }

    private fun raceOneRound(cars: List<Car>) {
        for (car in cars) {
            car.goForward()
        }
    }
}
