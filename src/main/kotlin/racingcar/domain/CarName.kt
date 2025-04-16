package racingcar.domain

class CarName(val name: String) {
    init {
        if (name.isEmpty()) {
            throw IllegalArgumentException("Car names must not be empty.")
        }
    }
}
