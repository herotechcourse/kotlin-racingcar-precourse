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

fun main() {
    try {
        getValidatedCarNames()
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
