package racingcar

class Car(
        val name: String,
        var movesMade: Int = 0,
) {
    companion object {
        private val MAX_NAME_LENGTH = 5
    }

    init {
        require(name.isNotBlank()) { "Each car must have a name" }
        require(name.length <= MAX_NAME_LENGTH) { "Names can't exceed $MAX_NAME_LENGTH characters" }
    }

    fun move() {
        movesMade++
    }
}
