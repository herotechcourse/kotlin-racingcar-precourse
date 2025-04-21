package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Application {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val game = RacingGame()
            game.start()
        }
    }
}

class RacingGame {
    private val cars = mutableListOf<Car>()
    private var rounds = 0

    fun start() {
        try {
            setupGame()
            playGame()
            announceWinners()
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    private fun setupGame() {
        inputCarNames()
        inputRounds()
    }

    private fun inputCarNames() {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        createCars(validateCarNames(input))
    }

    private fun validateCarNames(input: String): List<String> {
        val names = input.split(",").map { it.trim() }
        if (names.isEmpty()) throw IllegalArgumentException("Enter at least one car name.")
        if (names.any { it.isEmpty() }) throw IllegalArgumentException("Car name cannot be empty.")
        if (names.any { it.length > 5 }) throw IllegalArgumentException("Car names must be 5 characters or less.")
        return names
    }

    private fun createCars(names: List<String>) {
        names.forEach { cars.add(Car(it)) }
    }

    private fun inputRounds() {
        println("How many rounds will be played?")
        val input = Console.readLine()
        rounds = parseRounds(input)
    }

    private fun parseRounds(input: String): Int {
        return try {
            val number = input.toInt()
            if (number <= 0) throw IllegalArgumentException("Round count must be at least 1.")
            number
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Please input a valid number.")
        }
    }

    private fun playGame() {
        println("\nRace Result")
        repeat(rounds) {
            moveCars()
            printStatus()
        }
    }

    private fun moveCars() {
        cars.forEach { it.tryMove() }
    }

    private fun printStatus() {
        cars.forEach { println("${it.name} : ${"-".repeat(it.position)}") }
        println()
    }

    private fun announceWinners() {
        val max = cars.maxOfOrNull { it.position } ?: return
        val winners = cars.filter { it.position == max }.joinToString(", ") { it.name }
        println("Winners : $winners")
    }
}

class Car(val name: String) {
    var position = 0
        private set

    fun tryMove() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) position++
    }
}
