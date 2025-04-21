package racingcar.domain

data class Car(val name: String, var position: Int = 0) {
    fun canMove(number: Int): Boolean = number >= 4

    fun move(number: Int) {
        if (canMove(number)) {
            position++
        }
    }
}