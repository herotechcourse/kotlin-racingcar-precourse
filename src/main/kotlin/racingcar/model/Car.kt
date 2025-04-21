package racingcar.model

class Car(
    val name: String,
    private var position: Int = 0
) {
    init {
        validate(name)
    }

    fun move() {
        position++
    }

    fun getPosition(): Int = position

    private fun validate(name: String) {
        require(name.isNotBlank()) { "Car name cannot be blank" }
        require(name.length <= MAX_NAME_LENGTH) { "Car name cannot exceed $MAX_NAME_LENGTH characters" }
    }

    companion object {
        const val MAX_NAME_LENGTH = 5
    }
}