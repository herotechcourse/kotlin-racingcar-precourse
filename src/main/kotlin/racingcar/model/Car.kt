package racingcar.model

class Car(val name: String) {
    private var position = 0

    val racePosition: String
        get() = "-".repeat(position)

    fun move() {
        position++
    }
}