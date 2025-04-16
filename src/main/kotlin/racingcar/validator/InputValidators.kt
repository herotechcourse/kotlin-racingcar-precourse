package racingcar.validator

fun String?.checkEmptyInput() {
    if (this.isNullOrEmpty()) {
        throw IllegalArgumentException("[ERROR] Input cannot be empty.")
    }
}
