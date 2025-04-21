package racingcar

fun main() {
    val race = Race()
    race.playRace()
}

fun getInputCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val carNames = readLine() ?: throw IllegalArgumentException("Input cannot be null")
    return carNames.split(",")
}

fun getInputNumRounds(): Int {
    println("How many rounds will be played?")
    val input = readLine()
    val rounds = input?.toIntOrNull()
    if (rounds != null && rounds > 0) {
        return rounds
    } else {
        throw IllegalArgumentException("Input must be a valid positive integer")
    }
}
