package racingcar

class Car(val name: String, private val canMove: () -> Boolean) {
    var position: Int = 0
        private set
    fun moveForward() {
        if (canMove()) {
            position++
        }
    }

    fun printStatus() {
        println("$name : ${"-".repeat(position)}")
    }
}

fun main() {
    // TODO: Implement the program
}
