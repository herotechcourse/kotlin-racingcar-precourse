package racingcar

class Car(val name: String, var position: Int = 0) {
    fun moveForward() {
        position++
    }

    fun getPositionBar(): String {
        return "-".repeat(position)
    }
}