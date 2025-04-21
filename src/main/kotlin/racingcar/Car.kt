package racingcar

class Car(private val name: String) {
    var position = 0
        private set

    fun move(number: Int) {
        if (number >= 4) position++
    }

    fun getName(): String = name
}
