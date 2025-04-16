package racingcar

class Car(private val name: String) {

    private var position = 0

    companion object {
        const val MAX_NAME_LENGTH = 5
        const val MOVE_THRESHOLD = 4
    }

    init{
        if(name.length > MAX_NAME_LENGTH) {
            throw IllegalArgumentException("Car name must have at least 5 characters")
        }
    }

    fun move() {
        if (RandomNumberGenerator.generate() >= MOVE_THRESHOLD) {
            position++
        }
    }

}