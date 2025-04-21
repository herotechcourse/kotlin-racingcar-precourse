package racingcar.domain

class Car(val name: CarName, private val powerGenerator: PowerGenerator) {
    companion object {
        const val MIN_POWER_TO_MOVE = 4
        const val INITIAL_POSITION = 0
    }

    private var _position = Position(INITIAL_POSITION)
    val position: Position
        get() = _position

    fun move() {
        if (canMove()) {
            _position = _position.increase()
        }
    }

    private fun canMove(): Boolean {
        return powerGenerator.generate() >= MIN_POWER_TO_MOVE
    }
}
