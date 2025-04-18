package racingcar

class Car(val name: String) {
    private var position: Int = 0

    fun attemptMove(shouldMove: Boolean) {
        if (shouldMove) {
            position++
        }
    }

    fun getPosition(): Int {
        return position
    }
}