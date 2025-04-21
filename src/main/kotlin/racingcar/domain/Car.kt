package racingcar.domain

class Car(val name: String) {

    private var position: Int = 0

    fun getPosition(): Int {
        return position
    }
    fun moveForward() {
        position += 1
    }
}