package racingcar.domain

data class Car(
    val name: String,
    var position: Int = 0
) {
    fun moveForward() {
        val randomNumber = NumberGenerator.createRandomNumber()
        if (isMovable(randomNumber)) {
            position++
        }
    }

    private fun isMovable(number: Int): Boolean {
        return number >= 4
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