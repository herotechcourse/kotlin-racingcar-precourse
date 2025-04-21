package racingcar

class Car(val name: String) {
    var position = 0
        private set

    fun moveForward() {
        position++
    }
}