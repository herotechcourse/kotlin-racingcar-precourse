package racingcar.model

class Car(
    var name: String,
    var position: Int = INITIAL_POSITION,
) {
    companion object {
        private const val INITIAL_POSITION = 0
    }
}