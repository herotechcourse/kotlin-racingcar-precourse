package racingcar.model

class Car(
    val name: String,
    var position: Int = INITIAL_POSITION,
) {
    companion object {
        private const val INITIAL_POSITION = 0
        private const val MIN_MOVABLE_NUMBER = 4

        fun fromNames(names: List<String>): List<Car> {
            return names.map { Car(it) }
        }
    }

    fun moveForward() {
        position++
    }

    fun moveRandomly(randomNumber: Int) {
        if (randomNumber >= MIN_MOVABLE_NUMBER) {
            moveForward()
        }
    }
}