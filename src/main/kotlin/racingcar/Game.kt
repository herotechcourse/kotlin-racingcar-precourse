package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Game(val cars: List<Car>) {
    companion object {
        const val moveIndicator: Int = 4
		const val randMin: Int = 0
		const val randMax: Int = 9
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
                if (Randoms.pickNumberInRange(randMin, randMax) >= moveIndicator) car.move()
                car.printRoundStatus()
            }
            println("")
        }
    }

    private fun printWinners() {
        var maxWon = cars.maxOf { car -> car.getMovesMade() }
        val winners = cars.filter { car -> car.getMovesMade() == maxWon }
		print("Winners: " + winners.joinToString(", ") { it.getName() })
	}
}
