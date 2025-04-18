package racingcar

class Car(val name: String) {
    var position: Int = 0
        private set

    fun move(shouldMove: Boolean) {
        if (shouldMove) position++
    }

    override fun toString(): String {
        return "$name : ${"-".repeat(position)}"
    }
}