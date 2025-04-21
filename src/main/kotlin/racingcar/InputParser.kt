package racingcar

fun String.toCars(): List<Car> {
    this.validateNotBlank()
    val carNames = this.parseCarNames()
    carNames.validateNoBlankNames()
    carNames.validateNameLengths()
    carNames.validateNoDuplicates()

    return carNames.map { Car(it) }
}

fun String.toNumberOfRounds(): Int {
    this.validateNotBlank()
    val number = this.toIntOrNull() ?: throw IllegalArgumentException("Only numbers are allowed.")
    number.validatePositive()
    return number
}

internal fun String.validateNotBlank() {
    if (this.isBlank()) {
        throw IllegalArgumentException("You didn't type anything.")
    }
}

internal fun String.parseCarNames(): List<String> {
    return this.split(",").map { it.trim() }
}

internal fun List<String>.validateNoBlankNames() {
    if (this.any { it.isBlank() }) {
        throw IllegalArgumentException("Each car must have a name — no blanks allowed between commas.")
    }
}

internal fun List<String>.validateNoDuplicates() {
    if (this.size != this.toSet().size) {
        throw IllegalArgumentException("Car names must be unique.")
    }
}

internal fun List<String>.validateNameLengths() {
    val invalidNames = this.filter { it.length > 5 }
    if (invalidNames.isNotEmpty()) {
        throw IllegalArgumentException("Car names must be 1–5 characters long.")
    }
}

internal fun Int.validatePositive() {
    if (this <= 0) {
        throw IllegalArgumentException("Round count must be a positive integer.")
    }
}
