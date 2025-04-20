package racingcar

fun parseCarNames(input: String): List<String> {
    val names = input.split(",").map { it.trim() }
    require(names.isNotEmpty()) { "At least one car name must be provided." }
    names.forEach { name ->
        require(name.isNotBlank()) { "Car names cannot be empty or whitespace only." }
        require(name.length <= 5) { "Car name '$name' must be at most 5 characters." }
    }
    return names
}

fun parseRounds(input: String): Int {
    val number = input.toIntOrNull()
        ?: throw IllegalArgumentException("Number of rounds must be a number.")
    require(number >= 1) { "Number of rounds must be at least 1." }
    return number
}
