package racingcar

fun validateCarsInput(input: String) {
    checkBlank(input)
    checkInvalidChars(input)
    checkCommas(input)
    checkLength(input)
    checkDuplicates(input)
}

fun validateRoundsInput(input: String) {
    checkBlank(input)
    checkDigits(input)
    checkLimits(input)
}

fun checkBlank(input: String) {
    if (input.isBlank()) throw IllegalArgumentException("Input cannot be empty")
}

fun checkInvalidChars(input: String) {
    val invalidChars = Regex("[^a-zA-Z0-9,]")
    if (invalidChars.containsMatchIn(input)) throw IllegalArgumentException("Cars names cannot contain invalid characters or spaces")
}

fun checkCommas(input: String) {
    if (!input.contains(',')) throw IllegalArgumentException("You should enter at least two car names")
    if(input.contains(",," )) throw IllegalArgumentException("Cars names cannot be empty between commas")
    if (input.endsWith(",")) throw IllegalArgumentException("Input cannot end with a comma")
}

fun checkDuplicates(input: String) {
    val cars = input.split(',')

    if (cars.size != cars.toSet().size) {
        throw IllegalArgumentException("Car names cannot contain duplicates")
    }
}

fun checkLength(input: String) {
    val cars = input.split(',')
    for (car in cars) {
        if (car.length > 5) { throw IllegalArgumentException("Car name $car is longer than 5 characters") }
    }
}

fun checkDigits(input: String) {
    val validChars = Regex("^[0-9]+$")
    if (!validChars.matches(input)) throw IllegalArgumentException("Please enter only digits")
}

fun checkLimits(input: String) {
    val n = input.toLong()
    if (n > 1000) throw IllegalArgumentException("Number of rounds cannot be greater than 1000 (or the cars will be tired)")
    if (n <= 0) throw IllegalArgumentException("Number of rounds cannot be zero or negative")
}

