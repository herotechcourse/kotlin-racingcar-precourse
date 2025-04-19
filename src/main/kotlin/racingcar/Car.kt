package racingcar

class Car(val name: String, var roundPoints: Int = 0) {
    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("Car name cannot be blank.")
        }
        if (name.length > 5) {
            throw IllegalArgumentException("Car name '$name' should not exceed 5 characters.")
        }
    }
}