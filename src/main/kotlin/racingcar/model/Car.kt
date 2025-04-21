package racingcar.model

data class Car(
    val name: Name,
    var position: Position = Position.initial()
) {

    fun move(power: Int) {
        if (power >= MOVE_THRESHOLD) {
            position = position.move()
        }
    }

    companion object {
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

@JvmInline
value class Position(val value: Int) : Comparable<Position> {

    init {
        require(value >= INITIAL_VALUE) { "Position cannot be negative." }
    }

    fun move(): Position = Position(value + MOVE_DISTANCE)

    override fun compareTo(other: Position): Int = value.compareTo(other.value)

    companion object {
        private const val INITIAL_VALUE: Int = 0
        private const val MOVE_DISTANCE: Int = 1
        fun initial() = Position(INITIAL_VALUE)
    }
}
