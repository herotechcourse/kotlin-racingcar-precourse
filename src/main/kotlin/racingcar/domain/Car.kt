package racingcar.domain

class Car(name: String, position: Int = 0) {
    init {
        require(name.isNotBlank()) { "Car name must not be blank" }
        require(name.length <= MAX_NAME_LENGTH) { "Car name cannot exceed 5 characters" }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}