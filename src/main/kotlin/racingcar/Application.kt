package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println(
        buildString {
            append("Enter the names of the cars. Make sure to:\n- Separate them by a comma and no spaces.")
            append("\n- Use less than five characters per car name.")
        },)
    val carNames = Console.readLine()
    //Separates car names
    val separatedCarNames = carSeparator(carNames)
    // To test the carSeparator function
    //   println(separatedCarNames)

    //Run validations
    validateCarNames(separatedCarNames)
    println("Enter the number of rounds to race:")
    val numberOfRounds = Console.readLine()


}

private fun carSeparator(carNames: String): List<String> {
    val listOfCars = carNames.split(",").map { it.trim() }
    return listOfCars
}

private fun validateCarNames(separatedCarNames: List<String>) {
    if (separatedCarNames.isEmpty()) {
        throw IllegalArgumentException("Please provide the car names")
    }
    validateEachCar(separatedCarNames)
}

private fun validateEachCar(separatedCarNames: List<String>) {
    separatedCarNames.forEach { name ->
        validateSpaces(name)
        validateEmpty(name)
        validateNameLength(name)
    }
}

private fun validateSpaces(str: String): Boolean {
    return !str.any { it.isWhitespace() }
}

private fun validateEmpty(name: String) {
    if (name.isEmpty()) {
        throw IllegalArgumentException("You didn't provide a car name.")
    }
}

private fun validateNameLength(name: String) {
    if (name.length > 5) {
        throw IllegalArgumentException("The car '$name' is longer than 5 characters.")
    }
}
