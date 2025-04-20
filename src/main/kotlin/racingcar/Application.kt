package racingcar
import camp.nextstep.edu.missionutils.Console
fun main() {
    println("Enter the names of the cars (comma-separated):")
    val input = Console.readLine()
    val carNames = input.split(",").map { it.trim() }

    validateCarNames(carNames)

    println("How many rounds will be played?")
    val roundsInput = Console.readLine()

    val numberOfRounds = try {
        roundsInput.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("Number of rounds must be a valid integer.")
    }

    if (numberOfRounds <= 0) {
        throw IllegalArgumentException("Number of rounds must be greater than 0.")
    }

}

fun validateCarNames(carNames: List<String>) {
    for (name in carNames){
        if(name.isEmpty() || name.length > 5) {
            throw IllegalArgumentException("Each car name must be 1 to 5 characters long.")
        }
    }
}
