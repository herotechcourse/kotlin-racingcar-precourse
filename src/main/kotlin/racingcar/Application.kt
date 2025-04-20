package racingcar

import camp.nextstep.edu.missionutils.Console


fun main() {
    val carNames = getCarNames()
    val nOfRounds = getNumberOfRounds()
    println()

    val cars = carNames.map { Car(it) }

    val cr = CarRace(cars, nOfRounds)
    cr.play()
    println("Winners : ${cr.getWinners()}")
}


fun getCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val userInput = Console.readLine().trim()
    return InputProcessor().getValidatedCarNames(userInput)
}


private fun getNumberOfRounds(): Int {
    println("How many rounds will be played?")
    val userInput = Console.readLine().trim()
    return InputProcessor().getValidatedNumberOfRounds(userInput)
}
