package racingcar

class Car(val name: String) {
    private var position: Int = 0
        private set

    fun attemptMove(shouldMove: Boolean) {
        if (shouldMove) {
            position++
        }
    }
}