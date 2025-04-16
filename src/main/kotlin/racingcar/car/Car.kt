package racingcar.car

class Car(val name: String) {
    var position: Int = 0
        private set

    fun moveForward() {
        position++
    }
}