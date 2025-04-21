package racingcar.model

class Car(
    val carName: String,
    private val intGeneratorStrategy: IntGeneratorStrategy
) {
    var position: Int = 0
        private set

    fun tryMove() {
        if (canMove()) {
            position += ONE_FORWARD_MOVE_DISTANCE
        }
    }

    private fun canMove(): Boolean {
        return intGeneratorStrategy.getIntValue() >= MINIMUM_CAN_MOVE_CONDITION
    }

    companion object {
        private const val MINIMUM_CAN_MOVE_CONDITION = 4
        private const val ONE_FORWARD_MOVE_DISTANCE = 1
    }
}
