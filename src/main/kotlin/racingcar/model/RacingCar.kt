package racingcar.model

private const val MOVE_TRIGGER_VALUE = 4
private const val MAX_NAME_LENGTH = 5

class RacingCar internal constructor(
    val name: String,
    private var position: Int
) {
    constructor(name: String) : this(name, 0)

    init {
        require(name.length <= MAX_NAME_LENGTH && name.isNotBlank()) {
            throw IllegalArgumentException("Each car must have a name, and names cannot exceed $MAX_NAME_LENGTH characters.")
        }
    }

    fun moveForwardIfPossible(randomNumber: Int) {
        if (randomNumber >= MOVE_TRIGGER_VALUE) {
            position++
        }
    }

    val progress: Int
        get() = position

    fun copy(): RacingCar = RacingCar(name, position)
}