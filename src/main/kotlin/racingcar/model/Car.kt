package racingcar.model

data class Car(
    val name: Name,
    var position: Int = INITIAL_VALUE
) : Comparable<Car> {

    init {
        require(position >= INITIAL_VALUE) { "Position cannot be negative." }
    }

    fun move(power: Int) {
        if (power >= MOVE_THRESHOLD) {
            position += MOVE_DISTANCE
        }
    }

    override fun compareTo(other: Car): Int = position.compareTo(other.position)

    companion object {
        private const val INITIAL_VALUE: Int = 0
        private const val MOVE_DISTANCE: Int = 1
        private const val MOVE_THRESHOLD: Int = 4
    }

}

@JvmInline
value class Name(val name: String) {

    init {
        require(name.isNotBlank()) { "Car must have a name." }
        require(name.length <= MAX_CAR_NAME_LENGTH) { "Name cannot exceed 5 characters." }
    }

    companion object {
        const val MAX_CAR_NAME_LENGTH = 5
    }
}
