package racingcar.model

class Car(
    val name: String,
    var position: Int = INITIAL_POSITION,
) {
    fun moveRandomly(randomNumber: Int) {
        if (randomNumber >= MIN_MOVABLE_NUMBER) moveForward()
    }

    private fun moveForward() {
        position++
    }

    companion object {
        private const val INITIAL_POSITION: Int = 0
        private const val MIN_MOVABLE_NUMBER: Int = 4

        fun fromNames(names: List<String>): List<Car> = names.map { Car(it) }
    }
}