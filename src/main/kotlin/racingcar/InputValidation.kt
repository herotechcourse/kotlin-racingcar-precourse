package racingcar

fun validateCarsInput(input: String) {
    val invalidChars = Regex("[^a-zA-Z0-9,]")

    when {
        input.isBlank() -> throw IllegalArgumentException("Cars names cannot be empty")
        invalidChars.containsMatchIn(input) -> throw IllegalArgumentException("Cars names cannot contain invalid characters or spaces")
        !input.contains(',') -> throw IllegalArgumentException("You should enter at least two car names")
        input.contains(",," ) -> throw IllegalArgumentException("Cars names cannot be empty between commas")
        input.endsWith(",") -> throw IllegalArgumentException("Input cannot end with a comma")
    }
    checkInputLen(input)
}

fun checkInputLen(input: String) {
    val cars = input.split(',')

    for (car in cars) {
        if (car.length > 5) { throw IllegalArgumentException("Car name $car is longer than 5 characters") }
    }
}


fun validateRoundsInput(input: String) {
    val validChars = Regex("^[0-9]+$")

    when {
        !validChars.matches(input) -> throw IllegalArgumentException("Please enter only digits")
        input.isBlank() -> throw IllegalArgumentException("Number of rounds cannot be empty")
        input.toLong() > 10 -> throw IllegalArgumentException("Number of rounds cannot be greater than 10 (or the cars will be tired)")
        // review limit of rounds later
        input.toInt() <= 0 -> throw IllegalArgumentException("Number of rounds cannot be zero or negative")
    }
}
