package racingcar.domain

class Car(val name: CarName, private val powerGenerator: PowerGenerator) {
    private var _position = Position(0)
    val position: Position
        get() = _position

    fun move() {
        if (canMove()) {
            _position = _position.increase()
        }
    }

    private fun canMove(): Boolean {
        return powerGenerator.generate() >= 4
    }
}
