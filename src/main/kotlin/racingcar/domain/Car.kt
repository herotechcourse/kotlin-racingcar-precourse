package racingcar.domain

data class Car(
    val name: String,
    var position: Int = 0
) {
    fun moveForward() {

    }

    private fun isMovable(): Boolean {

        return false
    }

    companion object {
        fun validateCar(name: String) {

        }
    }
}
