package racingcar.domain

class CarName(val name: String) {
    init {
        if (name.isEmpty()) {
            throw IllegalArgumentException("Car names must not be empty.")
        }
        if (name.length > 5) {
            throw IllegalArgumentException("Car names must not exceed 5 characters.")
        }
    }
}
