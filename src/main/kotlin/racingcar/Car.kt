package racingcar

class Car(private val name: String) {
    private var position: Int = 0

    fun move(number: Int) {
        if (number >= 4) position++
    }

    fun getPosition(): Int = position
    fun getName(): String = name
}