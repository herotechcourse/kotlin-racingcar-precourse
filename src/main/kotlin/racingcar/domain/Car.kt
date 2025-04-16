package racingcar.domain

class Car(val name: CarName, private val powerGenerator: PowerGenerator) {
    var distance = 0

    fun move() {
        if (canMove()) {
            distance++
        }
    }

    private fun canMove(): Boolean {
        return powerGenerator.generate() >= 4
    }
}
