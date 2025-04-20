package racingcar.domain

data class Car(
    val name: String,
    var position: Int = 0,
    private val moveStrategy: MoveStrategy = RandomMoveStrategy()
) {
    fun moveForward() {
        if (moveStrategy.isMovable()) {
            position++
        }
    }
    companion object {
        fun validateCar(name: String) {
            if (name.isBlank()) {
                throw IllegalArgumentException("Car name cannot be blank.")
            }
            if (name.length > 5) {
                throw IllegalArgumentException("Car name must be 5 characters or fewer.")
            }
        }
    }
}