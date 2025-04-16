package racingcar

fun main() {
    // TODO: Implement the program

}

fun getCarNames(): List<String> {

    do {
        println("Enter car names, must be separated by commas!:")
        val carNamesInput = readLine()?.trim() ?: continue
        val carNames = carNamesInput.split(",").map { it.trim() }

        if(carNames.all { it.isNotEmpty() && it.length <= 5 }) {
            return carNames
        } else {
            throw IllegalArgumentException("Name must not be empty and only 5 characters. Try again!")
        }

    } while (true)
}

fun getNumberOfRounds(): Int {
    while (true) {
        println("Number of rounds:")
        val numberOfRoundsInput = readLine()
        val numberOfRounds = numberOfRoundsInput?.toIntOrNull()

        if(numberOfRounds != null && numberOfRounds > 0) {
            return numberOfRounds
        } else {
            throw IllegalArgumentException("Invalid input: enter a positive number")
        }
    }
}
