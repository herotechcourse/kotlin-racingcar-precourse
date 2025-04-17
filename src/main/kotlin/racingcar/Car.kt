package racingcar

class Car(val name: String) {
    var position: Int = 0

    fun attemptMove(shouldMove: Boolean) {
        if (shouldMove) {
            position++
        }
    }
}