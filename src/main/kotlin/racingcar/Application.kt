package racingcar

 import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: Implement the program

    val cars = getCarNames()
    val rounds = getNumberOfRounds()

    val carPositions = mutableMapOf<String, Int>()
    cars.forEach { carPositions[it] = 0 }

}

fun getCarNames(): List<String> {

    do {
        println("Enter the names of the cars (comma-separated):")
        val carNamesInput = Console.readLine()?.trim() ?: continue
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
        println("How many rounds will be played?")
        val numberOfRoundsInput = Console.readLine()
        val numberOfRounds = numberOfRoundsInput?.toIntOrNull()

        if(numberOfRounds != null && numberOfRounds > 0) {
            return numberOfRounds
        } else {
            throw IllegalArgumentException("Invalid input: enter a positive number")
        }
    }
}
