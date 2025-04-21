package racingcar.model

class Car(var name: String) {
    var position = 0

    fun move() {
        position += 1
    }
}