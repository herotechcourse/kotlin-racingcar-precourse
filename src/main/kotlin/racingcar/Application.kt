package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // TODO: Implement the program
    // prompt user input for car names
    println("Enter the names of the cars (comma-separated):")
    val carNamesInput = Console.readLine()
    val carNames = validateInput(carNamesInput)

    // prompt user input for number of rounds
    println("How many rounds will be played?")
    val rounds = Console.readLine().toInt()

    // initialize car positions
    val carPositions = mutableMapOf<String, Int>()
    for (name in carNames) {
        carPositions[name] = 0
    }
    println("\nRace Results")

    // run the race
    repeat(rounds) {
        // increment car position if random number is 4 or greater
        for (name in carNames) {
            if (moveCar()) {
                carPositions[name] = carPositions.getValue(name) + 1
            }
        }

        // print results of each round
        for (name in carNames) {
            val position = carPositions.getValue(name)
            println("$name : ${"-".repeat(position)}")
        }
        println()
    }

    // find the highest position
    var maxPosition = 0
    for (position in carPositions.values) {
        if (position > maxPosition) {
            maxPosition = position
        }
    }

    // collect the names of cars that reached the max position
    val winners = mutableListOf<String>()
    for ((name, position) in carPositions) {
        if (position == maxPosition) {
            winners.add(name)
        }
    }

    // display the winners
    println("Winners : ${winners.joinToString(", ")}")
}

fun validateInput(input: String): List<String> {
    // names cannot exceed 5 characters
    val names = input.split(",")
    val result = mutableListOf<String>()

    for (name in names) {
        if (name.length > 5) {
            throw IllegalArgumentException("Car name '$name' is too long. Max 5 characters allowed.")
        }
        result.add(name)
    }
    return result
}

fun moveCar(): Boolean {
    // return true if randomly generated number is 4 or greater
    if (Randoms.pickNumberInRange(0, 9) >= 4) {
        return true
    } else {
        return false
    }
}