package racingcar

class Car(val name: String) {
    var position: Int = 0

    fun move() {
        position += 1
    }
}