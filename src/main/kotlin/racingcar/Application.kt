package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

/**
 * Entry point of the application.
 *
 * Handles the following flow:
 * 1. Prompts user to input car names and number of rounds.
 * 2. Validates inputs and creates Car instances.
 * 3. Simulates the race round by round.
 * 4. Prints race progress after each round.
 * 5. Determines and prints the winner(s).
 */
fun main() {
    println("Start your engines! Please enter the names of the cars that are about to race and remember to keep them short and separate them by a comma...Let's go!:")
    val carNamesInput = Console.readLine()

    val carNames = carNamesInput.split(",").map { it.trim() }

    if (carNames.any { it.isEmpty() || it.length > 5 }) {
        throw IllegalArgumentException("Hey! Every car must have a name no bigger than 5 characters.")
    }

    println("How many rounds will be played?")
    val roundsInput = Console.readLine()
    val numberOfRounds = roundsInput.toIntOrNull()
        ?: throw IllegalArgumentException("Hey! Please enter a valid integer for number of rounds.")

    if (numberOfRounds <= 0) {
        throw IllegalArgumentException("Hey! The number of rounds must be a positive integer.")
    }

    val cars = carNames.map { Car(it) }

    println("\nRace Results")
    repeat(numberOfRounds) {
        cars.forEach { car ->
            val shouldMove = Randoms.pickNumberInRange(0, 9) >= 4
            car.move(shouldMove)
            println(car.render())
        }
        println() // spacing between rounds
    }

    val maxPosition = cars.maxOf { it.getPosition() }

    val winners = cars
        .filter { it.getPosition() == maxPosition }
        .joinToString(", ") { it.getName() }

    println("Winners : $winners")

}
