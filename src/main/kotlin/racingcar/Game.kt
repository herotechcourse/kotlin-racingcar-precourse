package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Game(val cars: List<Car>) {
    companion object {
        const val moveIndicator: Int = 4
    }

    private var totalRounds = 0

    fun play(nRounds: Int = 0) {
        totalRounds = nRounds
        raceThem()
        printWinners()
    }

    private fun raceThem() {
        for (i in 0 until totalRounds) {
            cars.forEach { car ->
                if (Randoms.pickNumberInRange(0, 9) >= moveIndicator) car.move()
                car.printRoundStatus()
            }
            println("")
        }
    }

    private fun printWinners() {
        var maxWon = cars.maxOf { car -> car.getMovesMade() }
        var firstWinner = true
        print("Winners : ")
        cars.forEach { car ->
            if (car.getMovesMade() == maxWon) {
                printWinnerName(car, firstWinner)
                firstWinner = false
            }
        }
    }

    private fun printWinnerName(car: Car, firstWinner: Boolean) {
        if (!firstWinner) print(", ")
        print("${car.getName()}")
    }
}
