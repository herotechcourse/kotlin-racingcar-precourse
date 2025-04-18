package racingcar
import camp.nextstep.edu.missionutils.Console

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

}
