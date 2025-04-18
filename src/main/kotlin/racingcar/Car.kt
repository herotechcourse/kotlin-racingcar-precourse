package racingcar

class Car(val name: String) {
    var position: Int = 0
        internal set

    fun move(random: Int) {
        if (random >= 4) {
            position++
        }
    }

    fun display(): String {
        return "$name : ${"-".repeat(position)}"
    }
}