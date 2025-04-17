package racingcar.model

class Car(val name: String, private var position: Int = 0) {
    fun move() {
        position++
    }
}