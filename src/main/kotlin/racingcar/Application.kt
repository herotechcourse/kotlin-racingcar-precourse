package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Util {
    fun nameSplit(input: String) : List<String> {
        val names = input.split(",")
        validateContainsSpecialCharacters(names)
        return names
    }

    private fun validateContainsSpecialCharacters(names: List<String>) {
        val regex = Regex("^[a-z]+$")

        names.forEach {
            name ->
            if (!regex.matches(name)) {
                throw IllegalArgumentException("Car name must have small letters.")
            }
        }
    }
}

class Cars(val cars: MutableList<Car>) {
}

class Car(val name: String) {
    var currentPosition: Int = 0
}

class OutputView {
    fun welcome() {
        println("Enter the names of the cars (comma-separated):")
    }

    fun roundNumber() {
        println("How many rounds will be played?")
    }

    fun printResultMessage() {
        println()
        println("Race Results")
    }
}

class InputView {
    fun inputNames(): String {
        val input = Console.readLine()
        validateIsEmpty(input)
        validateInvalidSeparator(input)
        validateStartsWithComma(input)
        validateContainsWhitespace(input)
        validateEmptyName(input)
        return input
    }

    fun inputNumber(): String {
        val input = Console.readLine()
        validateIsEmpty(input)
        validateInvalidSeparator(input)
        validateContainsWhitespace(input)
        return input
    }

    private fun validateEmptyName(input: String) {
        if (input.contains(",,")) {
            throw IllegalArgumentException("input value can't have empty name.")
        }
    }

    private fun validateContainsWhitespace(input: String) {
        if (input.contains(" ")) {
            throw IllegalArgumentException("input value can't have whitespace")
        }
    }

    private fun validateStartsWithComma(input: String) {
        if (input.startsWith(",")) {
            throw IllegalArgumentException("input value can't start with comma")
        }
    }

    private fun validateInvalidSeparator(input: String) {
        if (input.contains(".")) {
            throw IllegalArgumentException("input value can't have '.'")
        }
    }

    private fun validateIsEmpty(input: String) {
        if (input.isEmpty()) {
            throw IllegalArgumentException("Car name can't be empty.")
        }
    }
}

class RacingCar {
    fun execute() {
        OutputView().welcome()
        val challengers = InputView().inputNames()

        OutputView().roundNumber()
        val rounds = InputView().inputNumber()

        OutputView().printResultMessage()

        val challengerList = Util().nameSplit(challengers)

        // make Car object
        var challengerGroup = mutableListOf<Car>()
        for (challenger in challengerList) {
            if (challenger.length > 5) {
                throw IllegalArgumentException("names cannot exceed 5 characters.")
            }
            challengerGroup.add(Car(challenger))
        }

//    Games()
        var currentRound = 0
        while (currentRound != rounds.toInt()) {
            for (challenger in challengerGroup) {
                val diceNumber = Randoms.pickNumberInRange(0, 9)
                if (diceNumber >= 4) {
                    challenger.currentPosition += 1
                }
            }

//        print current racing status
            for (challenger in challengerGroup) {
                print("${challenger.name} : ")
                for (p in 1..challenger.currentPosition) {
                    print("-")
                }
                println()
            }
            println()
            currentRound += 1
        }

        // search winners
        var winnerGroup = mutableListOf<String>()
        var tmp = 0
        challengerGroup.forEach { challenger ->
            if (challenger.currentPosition > tmp) {
                winnerGroup = mutableListOf<String>()
                winnerGroup.add(challenger.name)
                tmp = challenger.currentPosition
            } else if (challenger.currentPosition == tmp) {
                winnerGroup.add(challenger.name)
            }
        }

        // print winners
        print("Winners : ")
        println(winnerGroup.joinToString(", "))
    }
}

fun main() {
    RacingCar().execute()
}