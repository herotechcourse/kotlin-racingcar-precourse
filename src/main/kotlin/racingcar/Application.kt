package racingcar

fun validateCarNames(names: List<String>) {
    require(names.size >= 2) {
        "At least two cars are required to start the race."
    }

    names.forEach { name ->
        require(name.length <= 5) {
            "Car name ($name) cannot exceed 5 characters"
        }
    }
}

fun validateRounds(rounds: String) {
    if (rounds.isBlank() || rounds.any { !it.isDigit() }) {
        throw IllegalArgumentException("Number of rounds must be a positive number.")
    }

    val value = rounds.toInt()
    if (value < 1) {
        throw IllegalArgumentException("Number of rounds must be at least 1.")
    }
}


fun splitInputToCarNames(input: String): List<String> {
    return input.split(",").map { it.trim() }
}

fun getValidatedCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val input = readln()
    val names = splitInputToCarNames(input)
    validateCarNames(names)
    return names
}

fun inputRounds(): Int {
    println("How many rounds will be played?")
    val input = readln()
    validateRounds(input)
    return input.toInt()
}

fun main() {
    try {
        val names = getValidatedCarNames()
        val rounds = inputRounds()
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
