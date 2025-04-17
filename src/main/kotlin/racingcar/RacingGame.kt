package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingGame(
    private val carNames: List<String>,
    private val rounds: Int,
) {

    private val cars = carNames.map { Car(it) }

    fun run() {
        printRaceStart()
        playRace(cars, rounds)
    }

    // TODO Implement Output handler - for now use a unit function
//    OutputHandler.printRaceStart()
    private fun printRaceStart() {
        println("\nRace Results")
    }

    private fun playRace(cars: List<Car>, rounds: Int) {
        repeat(rounds) {
            cars.forEach { it.attemptMove(Randoms.pickNumberInRange(0, 9) >= 4) }
            printRaceResult(cars)
        }
        printWinners(cars)
    }

    private fun printRaceResult(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }

    private fun printWinners(cars: List<Car>) {
        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }.map { it.name }
        println("Winners : ${winners.joinToString(", ")}")
    }
}