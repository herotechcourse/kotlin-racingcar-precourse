package racingcar.domain

class Car(val name: CarName, private val powerGenerator: PowerGenerator) {
    var position = Position(0)

    fun move() {
        if (canMove()) {
            position = position.increase()
        }
    }

    private fun canMove(): Boolean {
        return powerGenerator.generate() >= 4
    }
}
