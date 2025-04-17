package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

const val MINIMUM_MOVE = 4

fun main() {
    val carNames = getCarNames()
    val carPositions = carNames.associateWith { 0 }.toMutableMap()
    val totalRounds = getTotalRounds()
    println("Race Results")
    playRace(carPositions, totalRounds)
    printWinners(carPositions)
}

fun getCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated):\n")
    val carNames = Console.readLine().split(",").map { it.trim() }
    carNames.forEach { carName ->
        if (carName.isEmpty() || carName.length > 5) {
            throw IllegalArgumentException("Car names must not be empty and must be 5 characters or less")
        }
    }
    return carNames
}

fun getTotalRounds(): Int {
    println("How many rounds will be played?\n")
    return Console.readLine().toInt()
}

fun playRace(carPositions: MutableMap<String, Int>, totalRounds: Int) {
    for (round in 1..totalRounds) {
        for ((carName, position) in carPositions) {
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            if (randomNumber >= MINIMUM_MOVE) {
                carPositions[carName] = position + 1
            }
            println("$carName : " + "-".repeat(carPositions[carName]!!))
        }
        println()
    }
}

fun printWinners(carPositions: Map<String, Int>) {
    val maxPosition = carPositions.values.maxOrNull() ?: 0
    val winners = carPositions.filterValues { it == maxPosition }.keys
    println("Winners : ${winners.joinToString(", ")}")
}
