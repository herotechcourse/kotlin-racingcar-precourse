package racingcar.domain

class Car(val name: String) {
    // Current position of the car, starts at 0.
    var position: Int = 0
        private set

    // Moves the car forward if the random number meets the criteria.
    fun move(randomNumber: Int) {
        if (randomNumber >= MOVE_FORWARD_MIN_VALUE) {
            position++
        }
    }
}