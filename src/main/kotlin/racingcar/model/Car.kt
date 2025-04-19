package racingcar.model

class Car(val name: String) {
    var position: Int = 0

    fun move() {
        position++
    }

    fun getRoundResult(): String {
        val marks = "-".repeat(position)
        return "$name : $marks"
    }
}