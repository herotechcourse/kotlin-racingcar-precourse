package racingcar.model

// Car class represents one car in the game
// name must be valid (not blank, max 5 chars)
class Car(val name: String) {

    init {
        require(name.isNotBlank()) { "Car name cannot be blank!" }
        require(name.length <= 5) { "Car name must be 5 characters or less!" }
    }

    // how far the car moved, starts at 0
    // private setter
    var position: Int = 0
        private set

    // move forward by 1 (called when car passes condition)
    fun move() {
        position += 1
    }
}
