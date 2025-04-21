package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Game(val cars: List<Car>) {
    private var totalRounds = 0

    fun play(nRounds: Int = 0) {
        totalRounds = nRounds
        raceThem()
        printWinners()
    }

    private fun raceThem() {
        for (i in 0 until totalRounds) {
            playRound()
            println("")
        }
    }

    private fun playRound() {
        for (car in cars) {
            if (Randoms.pickNumberInRange(randMin, randMax) >= moveIndicator) car.move()
            car.printRoundStatus()
        }
    }

    private fun printWinners() {
        var maxWon = cars.maxOf { car -> car.getMovesMade() }
        val winners = cars.filter { car -> car.getMovesMade() == maxWon }
        println("Winners : " + winners.joinToString(", ") { it.getName() })
    }

    companion object {
        const val moveIndicator: Int = 4
        const val randMin: Int = 0
        const val randMax: Int = 9
    }
}
