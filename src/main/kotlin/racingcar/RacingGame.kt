package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingGame(private val cars: List<Car>) {

    fun playRound() {
        cars.forEach { car ->
            val number = Randoms.pickNumberInRange(0, 9)
            car.move(number)
        }
    }

    fun runRounds(roundCount: Int) {
        println("\nRace Results")
        repeat(roundCount) {
            playRound()
            printRound()
        }
        printWinners()
    }

    private fun printRound() {
        cars.forEach { car ->
            println("${car.name} : ${car.getProgress()}")
        }
        println()
    }

    private fun printWinners() {
        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }
            .joinToString(", ") { it.name }

        println("Winners : $winners")
    }

    fun getCars(): List<Car> = cars
}
