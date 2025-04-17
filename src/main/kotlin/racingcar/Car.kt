package racingcar

class Car(
    private val name: String,
    private var position: Int,
    private val engine: Engine) {

    fun goForward() {
        position += engine.move()
    }

    fun getPosition(): Int {
        return position
    }

    fun getName(): String {
        return name
    }
}