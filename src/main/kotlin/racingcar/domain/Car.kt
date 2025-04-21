package racingcar.domain

class Car(val name: String, var position: Int = 0) {
    init {
        require(name.isNotBlank()) { "Car name must not be blank" }
        require(name.length <= MAX_NAME_LENGTH) { "Car name cannot exceed 5 characters" }
    }

    fun moveIfOverThreshold(number: Int) {
        if (number >= MOVE_THRESHOLD) {
            position++
        }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
        private const val MOVE_THRESHOLD = 4
    }
}