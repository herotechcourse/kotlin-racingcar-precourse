package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

//fun main() {
//    // TODO: Implement the program
//    print("hi")
//}



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
            inputCarNames()
            inputRounds()
            race()
            announceWinners()
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    private fun inputCarNames() {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        validateAndCreateCars(input)
    }

    private fun validateAndCreateCars(input: String) {
        val carNames = input.split(",").map { it.trim() }

        if (carNames.isEmpty()) {
            throw IllegalArgumentException("Enter the names of the cars (comma-separated):")
        }

        carNames.forEach { name ->
            if (name.isEmpty()) {
                throw IllegalArgumentException("you can't input empty name")
            }
            if (name.length > 5) {
                throw IllegalArgumentException("names cannot exceed 5 characters: $name")
            }
            cars.add(Car(name))
        }
    }

    private fun inputRounds() {
        println("How many rounds will be played?")
        val input = Console.readLine()
        validateAndSetRounds(input)
    }

    private fun validateAndSetRounds(input: String) {
        try {
            rounds = input.toInt()
            if (rounds <= 0) {
                throw IllegalArgumentException("round must be at least 1")
            }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("input number.")
        }
    }

    private fun race() {
        println("\nresult")
        repeat(rounds) {
            moveAllCars()
            printRaceStatus()
        }
    }

    private fun moveAllCars() {
        cars.forEach { car ->
            car.tryMove()
        }
    }

    private fun printRaceStatus() {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }

    private fun announceWinners() {
        val maxPosition = cars.maxOfOrNull { it.position } ?: 0
        val winners = cars.filter { it.position == maxPosition }

        val winnerNames = winners.joinToString(", ") { it.name }
        println("Winners : $winnerNames")
    }
}

class Car(val name: String) {
    var position = 0
        private set

    fun tryMove() {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if (randomNumber >= 4) {
            position++
        }
    }
}