package racingcar

class Car(private val name: String) {
    private var position: Int = 0

    fun move(number: Int) {
        if (number >= 4) {
            position++
        }
    }

    fun getName(): String = name

    fun getPosition(): Int = position

    fun printStatus() {
        println("$name : ${"-".repeat(position)}")
    }
}