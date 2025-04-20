package racingcar

class Car(val name: String) {
    var position: Int = 0
        private set

    fun move(randomNumber: Int) {
        if (randomNumber >= 4) {
            position++
        }
    }

    fun getProgress(): String {
        return "-".repeat(position)
    }
}
