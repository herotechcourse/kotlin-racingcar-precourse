package racingcar.model

class Car(val name: String) {
    companion object {
        const val MAX_NAME_LENGTH = 5
    }

    var position = 0
    private set

    init {
        require(name.isNotBlank() && name.length <= MAX_NAME_LENGTH) {
            "Car must have a name, and names cannot exceed 5 characters."
        }
    }

    fun move() {
    position++
    }
}