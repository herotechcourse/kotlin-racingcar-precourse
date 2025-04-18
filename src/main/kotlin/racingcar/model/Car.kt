package racingcar.model

class Car(val name: String) {
    companion object {
        const val MAX_NAME_LENGTH = 5
    }

    var position = 0
    private set

    fun move() {
        position++
    }
}