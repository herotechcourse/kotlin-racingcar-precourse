package racingcar

class Car(val name: String) {
    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("Car name cannot be blank.")
        }
        if (name.length > 5) {
            throw IllegalArgumentException("Car name '$name' should not exceed 5 characters.")
        }
    }
}