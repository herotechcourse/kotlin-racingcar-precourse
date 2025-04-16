package racingcar

data class Car(val name: String, var position: Int = 0) {
    fun move(forward: Boolean) {
        if (forward) {
            position++
        }
    }

    override fun toString(): String {
        return "$name: ${"-".repeat(position)}"
    }
}
