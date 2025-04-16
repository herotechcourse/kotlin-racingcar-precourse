package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carNames = Console.readLine()
    if (checkLength(carNames)) {
        throw IllegalArgumentException("Car name can not exceed 5 characters.")
    }

    println("How many rounds will be played?")
    val rounds = Console.readLine().toInt()

    val game = CarRacingGame(carNames, rounds)
    game.startGame()
}

fun checkLength(carNames: String): Boolean {
    return carNames.split(",").any { it.length > 5 }
}

class CarRacingGame(names: String, private val numberOfRounds: Int) {
    private val cars: List<Car> = names.split(",").map { Car(it) }
    private val winners = mutableListOf<Car>()

    fun startGame() {
        println("Race Results")
        repeat(numberOfRounds) {
            moveCars()
            println()
        }
        determineWinners()
    }

    private fun moveCars() {
        cars.forEach { car ->
            car.tryToMove()
            print("${car.name} : ")
            car.displayMoves()
            println()
        }
    }

    private fun determineWinners() {
        val maxMoves = cars.maxOf { it.moves }
        winners.addAll(cars.filter { it.moves == maxMoves })
        print("Winners : ")
        println(winners.joinToString(", ") { it.name })
    }
}

class Car(val name: String) {
    var moves: Int = 0
        private set

    fun tryToMove() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            moves++
        }
    }

    fun displayMoves() {
        repeat(moves) {
            print("-")
        }
    }
}
