package racingcar

fun main() {
    val carNames = inputCarNames()
    val raceController = RaceController()
    raceController.startRace(carNames)
}

fun inputCarNames(): List<String> {
    println("Input car names (separated by commas)")
    val input = readLine() ?: throw IllegalArgumentException("Input invalid!")
    if (!input.contains(",")) {
        throw IllegalArgumentException("Names must be separated by commas")
    }
    val carNames = input.split(",").map { it.trim() }
    if (carNames.any { it.length > 5}) {
        throw IllegalArgumentException("Names cannot be longer than 5 characters")
    }
    return carNames
}
    