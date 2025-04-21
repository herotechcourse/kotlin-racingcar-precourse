package racingcar.model

data class Car(
    val name: String,
    var position: Int = INITIAL_VALUE
) : Comparable<Car> {

    init {
        require(name.isNotBlank()) { "Car must have a name." }
        require(name.length <= MAX_CAR_NAME_LENGTH) { "Name cannot exceed 5 characters." }
        require(position >= INITIAL_VALUE) { "Position cannot be negative." }
    }

    fun move(power: Int) {
        if (power >= MOVE_THRESHOLD) {
            position += MOVE_DISTANCE
        }
    }

    override fun compareTo(other: Car): Int = position.compareTo(other.position)

    companion object {
        private const val MAX_CAR_NAME_LENGTH = 5
        private const val INITIAL_VALUE: Int = 0
        private const val MOVE_DISTANCE: Int = 1
        private const val MOVE_THRESHOLD: Int = 4
    }

}
