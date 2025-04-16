package racingcar.domain

class Car(val name: CarName, private val powerGenerator: PowerGenerator) {
    var position = 0

    fun move() {
        if (canMove()) {
            position++
        }
    }

    private fun canMove(): Boolean {
        return powerGenerator.generate() >= 4
    }
}
