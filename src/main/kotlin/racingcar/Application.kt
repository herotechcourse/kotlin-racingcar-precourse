package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


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
}

class InputView {
    fun input(): String {
        val input = Console.readLine()
        validateInput(input)
        return input
    }

    private fun validateInput(input: String) {
        if (input.isEmpty()) {
            throw IllegalArgumentException("Car name can't be empty.")
        }
    }
}

class RacingCar {
    fun execute() {
        OutputView().welcome()
        val challengers = InputView().input()
        OutputView().roundNumber()
        val rounds = InputView().input()

        println()
        println("Race Results")

        val challengerList = challengers.split(",") // [pobi, woni, jun]
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
