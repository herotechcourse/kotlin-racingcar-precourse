package racingcar.model

class Car(val name: String) {
    private var position = 0

    fun move() {
        position++
    }

    fun getPosition(): Int {
        return position
    }
}