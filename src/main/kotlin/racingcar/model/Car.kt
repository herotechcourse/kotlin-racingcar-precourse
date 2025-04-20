package racingcar.model

class Car(val name: String) {
    var position: Int = 0
        private set

    fun displayProgress(): String {
        val progress = "-".repeat(position)
        return "$name : $progress"
    }

    fun move() {
        position++
    }
}