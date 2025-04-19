package racingcar.domain

data class CarName(val value: String) {
    companion object {
        const val MAX_NAME_LENGTH = 5
    }

    init {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Car names must not be empty.")
        }
        if (value.length > MAX_NAME_LENGTH) {
            throw IllegalArgumentException("Car names must not exceed 5 characters.")
        }
    }
}
