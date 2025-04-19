package racingcar.models

class Car(val name: String) {
    private var position: Int = 0

    fun move(range: Int) {
        if (range >= 4) {
            this.position ++
        }
    }

    fun getPosition(): Int = position

    fun status(): String = "$name : ${"-".repeat(position)}"
}