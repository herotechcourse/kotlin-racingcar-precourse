package racingcar

class Car(val name: String) {

    var position: Int = 0

    fun move(shouldMove: Boolean) {
        if (shouldMove) {
            position++
        }
    }

    fun getPositionDisplay(): String = "-".repeat(position)

}