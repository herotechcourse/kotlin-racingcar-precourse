package racingcar

fun validateSingleCarName(carName: String) {
    when {
        carName.isEmpty() -> throw IllegalArgumentException("")
        carName.contains(" ") -> throw IllegalArgumentException("")
        carName.length > 5 -> throw IllegalArgumentException("")
    }
}

fun checkCarNameValidation(carNames: String) {
    val carNameList = carNames.split(",")
    carNameList.forEach { carName ->
        validateSingleCarName(carName)
    }
}

fun checkRoundValidation(numberStr: String) {
    val number = numberStr.toInt()
    if (number <= 0) {
        throw IllegalArgumentException("")
    }
}