package racingcar

fun getUserInputNames(): List<String> {
    println("Names of the cars (comma-separated):\n")

    val input = readln()
    if (input.isBlank()) throw IllegalArgumentException("Input must not be empty")

    val names: List<String> = input.split(',').map { it.trim() }
    if (names.size <= 1) throw IllegalArgumentException("There must be more than one car")
    return names
}

fun getUserInputRounds(): UInt {
    println("Number of rounds:")
    val numRounds =
            try {
                readln().toUInt()
            } catch (error: Throwable) {
                throw IllegalArgumentException("Input must be a positive integer")
            }
    validateRounds(numRounds)
    return numRounds
}

fun validateRounds(rounds: UInt) {
    when {
        rounds == 0u -> throw IllegalArgumentException("Number of rounds must be positive")
        rounds > maxRounds -> throw IllegalArgumentException("Maximum tounds exceeded")
    }
}