package racingcar

fun main() {
    val carNames = inputCarNames()
    val rounds = inputRounds()
    val raceController = RaceController()
    raceController.startRace(carNames, rounds)
}

fun inputCarNames(): List<String> {
    println("Input car names (separated by commas)")
    val input = readLine() ?: throw IllegalArgumentException("Input invalid!")
    val carNames = input.split(",").map { it.trim() }
    if (carNames.any { it.isEmpty() }) {
        throw IllegalArgumentException("Car names cannot be empty")
    }
    if (carNames.any { it.length > 5 }) {
        throw IllegalArgumentException("Car names cannot be longer than 5 characters")
    }
    return carNames
}

fun inputRounds(): Int {
    println("Input number of rounds")
    val input = readLine() ?: throw IllegalArgumentException("Input invalid!")
    val rounds = input.toInt()
    if (rounds <= 0) {
        throw IllegalArgumentException("Rounds must be greater than 0")
    }
    return rounds
}
    