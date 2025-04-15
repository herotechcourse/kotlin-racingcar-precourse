package racingcar

class Car(val name: String) {
    var position = 0
        private set

    init {
        require(name.isNotBlank()) { "Car name must not be blank" }
        require(name.length <= 5) { "Car name must not exceed 5 characters" }
    }

    fun move(canMove: Boolean) {
        if (canMove) position++
    }

    fun printProgress(): String = "$name : ${"-".repeat(position)}"
}