package racingcar

class Car private constructor(val name: String) {
    var position = 0
        private set

    companion object {
        fun create(name: String): Car {
            require(name.isNotBlank()) { "Car name must not be blank" }
            require(name.length <= 5) { "Car name must not exceed 5 characters" }
            return Car(name)
        }
    }

    fun move(canMove: Boolean) {
        if (canMove) position++
    }

    fun printProgress(): String = "$name : ${"-".repeat(position)}"
}
