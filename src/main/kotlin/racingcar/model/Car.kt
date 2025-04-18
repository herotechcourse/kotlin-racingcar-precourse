package racingcar.model

class Car(private val name: String) {
    private var position = 0

    fun getPosition(): Int {
        return position
    }

    fun getName(): String {
        return name
    }

    val racePosition: String
        get() = "-".repeat(position)

    fun move() {
        position++
    }
}