package racingcar

class Car(private val name: String) {
    private var position: Int = 0

    fun move(shouldMove: Boolean) {
        if (shouldMove) {
            position++
        }
    }

    fun getPosition(): Int = position

    fun getName(): String = name

    fun render(): String {
        return "$name : ${"-".repeat(position)}"
    }
}