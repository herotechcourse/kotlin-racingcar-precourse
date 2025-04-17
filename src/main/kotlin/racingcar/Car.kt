package racingcar

class Car(val carName: String) {
    init {
        require(carName.isNotEmpty()) { "Car name must not be empty" }
        require(carName.length <= 5) { "Car name must not exceed 5 characters" }
    }
}
