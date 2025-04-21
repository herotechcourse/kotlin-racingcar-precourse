package racingcar.domain


class Car(val name: String, var position: Int = 0) {
    init {
        require(name.isNotEmpty() && name.length <= 5) { "Car name must be between 1 and 5 characters" }
    }
}