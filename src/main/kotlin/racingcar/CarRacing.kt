package racingcar

import camp.nextstep.edu.missionutils.Randoms

object CarRacing {
    fun race(cars: List<Car>, numberOfRounds: Int) {
        printRaceHeader()

        raceRoundsAndPrintResult(cars, numberOfRounds)

        val winners = determinateWinner(cars)
        printWinners(winners)
    }

    private fun raceRoundsAndPrintResult(cars: List<Car>, numberOfRounds: Int) = repeat(numberOfRounds) { round ->
        raceSingleRound(cars)
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.getPosition())}")
        }
        println()
    }

    private fun determinateWinner(cars: List<Car>): List<String> {
        val maxPosition = cars.maxOf { it.getPosition() }
        return cars.filter { it.getPosition() == maxPosition }.map { it.name }
    }

    private fun printRaceHeader() = println("\nRace Results")

    private fun printWinners(winners: List<String>) = println("Winners : ${winners.joinToString(", ")}")

    private fun raceSingleRound(cars: List<Car>) = cars.forEach { car ->
        val number = Randoms.pickNumberInRange(0, 9)
        if (number >= 4) {
            car.moveForward()
        }
    }

}
