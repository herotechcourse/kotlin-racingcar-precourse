package racingcar.domain

class Car(val name: String, var position: Int = 0) {
    fun move() {
        if ((0..9).random() >= 4) {
            position++
        }
    }

    fun getPositionDisplay(): String = "-".repeat(position)
}
