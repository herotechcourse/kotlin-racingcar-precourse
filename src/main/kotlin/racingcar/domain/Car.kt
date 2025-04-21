package racingcar.domain

class Car(name: String, position: Int = 0) {
    init {
        require(name.isNotBlank()) { "Car name must not be blank" }
    }
}