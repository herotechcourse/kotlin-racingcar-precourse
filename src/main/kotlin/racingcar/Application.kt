package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Games(var challengers: String, var rounds: String) {
}

class Car(val name: String) {
    var currentPosition: Int = 0
}

fun main() {
    try {
        // racing start introducing comment
        println("Enter the names of the cars (comma-separated):")
        val challengers = Console.readLine()
        if (challengers.isEmpty()) {
            throw IllegalArgumentException("Car name can't be empty.")
        }

        println("How many rounds will be played?")
        val rounds = Console.readLine()
//    if (rounds.toInt() < 2) {
//        throw IllegalArgumentException("Race round is more than 1")
//    }

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
    } catch (e: IllegalArgumentException) {
        throw IllegalArgumentException("test")
    }
}
