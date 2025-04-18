package racingcar

fun validateSingleCarName(carName: String) {
    when {
        carName.isEmpty() -> throw IllegalArgumentException("Car name cannot be empty.")
        carName.contains(" ") -> throw IllegalArgumentException("Car name cannot contain spaces.")
        carName.length > 5 -> throw IllegalArgumentException("Car name cannot exceed 5 characters.")
    }
}

fun checkCarNameValidation(carNames: String) {
    if (carNames.isEmpty()) {
        throw IllegalArgumentException("Car names input cannot be empty.")
    }

    if (carNames.endsWith(",")) {
        throw IllegalArgumentException("Car names input cannot end with a comma.")
    }

    val carNameList = carNames.split(",")

    if (carNameList.isEmpty()) {
        throw IllegalArgumentException("At least one car name must be provided.")
    }

    val uniqueNames = carNameList.toSet()
    if (uniqueNames.size != carNameList.size) {
        throw IllegalArgumentException("All car names must be unique.")
    }

    carNameList.forEach { carName ->
        validateSingleCarName(carName)
    }
}

fun checkRoundValidation(numberStr: String) {
    try {
        val number = numberStr.toInt()
        if (number <= 0) {
            throw IllegalArgumentException("Number must be positive")
        }
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("Number must be integer")
    }

}