package racingcar
import camp.nextstep.edu.missionutils.Randoms

data class Race(val cars: List<Car>, val roundNum: Int) {

    private val carMoves: MutableMap<String, Int> = mutableMapOf()

    init {
        for (car in cars) {
            carMoves[car.name] = 0
        }
    }

    private fun moveForward(car: Car) {
        carMoves[car.name] = carMoves.getValue(car.name) + 1
    }

    private fun formatMoveResult(car: Car): String {
        val moveCount = carMoves.getValue(car.name)
        return "${car.name} : ${"-".repeat(moveCount)}"
    }

    fun runRace() {
        println("Race Results")
        repeat(roundNum) {
            runRound()
            println()
        }
    }

    private fun runRound() {
        for (car in cars) {
            if (getRandomNumber() >= 4) {
                moveForward(car)
            }
            println(formatMoveResult(car))
        }
    }

    private fun getWinnerNames(): List<String> {
        val maxMove = carMoves.maxOf { it.value }
        return carMoves.filter { it.value == maxMove }.map { it.key }
    }

    fun printWinners() {
        val winners = getWinnerNames()
        println("Winners : ${winners.joinToString(", ")}")
    }

    private fun getRandomNumber() = Randoms.pickNumberInRange(0, 9)
}
