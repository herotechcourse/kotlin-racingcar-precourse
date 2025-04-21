package racingcar.model

private const val MOVE_TRIGGER_VALUE = 4

class RacingCar(
    private val name: String,
    private var position: Int
) {
    constructor(name: String) : this(name, 0)

    fun moveForwardIfPossible(randomNumber: Int) {
        if(randomNumber >= MOVE_TRIGGER_VALUE) {
            position++
        }
    }
}