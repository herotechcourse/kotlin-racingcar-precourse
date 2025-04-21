package racingcar.domain

class Car(val name: String) {
    private var position = 0

    fun move(randomNumber: Int) {
        if (randomNumber >= 4) {
            position++
        }
    }

    fun getPosition(): Int {
        return position
    }

    override fun toString(): String {
        return "$name : ${"-".repeat(position)}"
    }
}