package racingcar

import camp.nextstep.edu.missionutils.Console
import kotlin.math.round

class Game() {
    var round: Int = 0
        private set
    // Get car input
    fun nameInput(): List<String>{
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        return input.trim().split(",")
    }

    // Get number of rounds input
    fun roundInput() {
        println("How many rounds will be played?")
        val input = Console.readLine()
        val number = input.toIntOrNull()

        if (number == null) {
            throw IllegalArgumentException("Please enter a valid number")
        } else if (number < 0) {
            throw IllegalArgumentException("Number of rounds must be greater than 0")
        } else {
            round = number
        }
    }
}

fun main() {
    val game = Game()
    var board = Board()

    val names = game.nameInput()

    // Save cars
    for (name in names) {
        var car = Car()
        car.setName(name)
        board.setCars(car)
    }

    // Save number of rounds
    game.roundInput()

    for (i in 1..game.round) {
        for (car in board.cars) {
            car.moveCar(car.generateNumber())
        }
        board.printRound()
    }

    board.printResult(board.checkWinner())

}


