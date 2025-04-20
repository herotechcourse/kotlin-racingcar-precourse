package racingcar.model

class Car(val name: String) {

    init {
        require(name.isNotBlank() && name.length in 1..5) {
            "The car name must be at least 1 character and no more than 5 characters. Input value: '$name'"
        }
    }

    val position: Int
        get() = _position

    private var _position = 0

    fun moveForward(randomValue: Int) {
        if (randomValue >= 4) { _position++ }
    }

    fun drawPosition(): String {
        return "-".repeat(position)
    }
}