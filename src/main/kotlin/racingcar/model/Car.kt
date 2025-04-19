package racingcar.model

class Car(val name: String) {
    var position: Int = DEFAULT_POSITION
        private set

    fun move(condition: Int) {
        if (condition >= MOVABLE_CONDITION) {
            position++
        }
    }

    companion object {
        private const val DEFAULT_POSITION = 0
        private const val MOVABLE_CONDITION = 4
    }
}
