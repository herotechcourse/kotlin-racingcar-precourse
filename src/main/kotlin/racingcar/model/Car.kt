package racingcar.model

class Car(val name: String) {
    var position: Int = DEFAULT_POSITION
        private set

    companion object {
        private const val DEFAULT_POSITION = 0
    }
}
