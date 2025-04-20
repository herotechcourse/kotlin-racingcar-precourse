package racingcar.model
import camp.nextstep.edu.missionutils.Randoms

open class Car(
    val id: Int,
    val name: String,
    var position: Int = 0
) {
    init {
        validateName(name)
    }

    private fun validateName(name: String) {
        require(name.trim().isNotEmpty()) { "Car name cannot be empty" }
        require(name.length <= MAX_NAME_LENGTH) { "Car name cannot have more then $MAX_NAME_LENGTH characters" }
    }

    fun move() {
        if (shouldMove()) {
            position++
        }
    }

    private fun shouldMove(): Boolean {
        return getRandomNumber() >= FORWARD_THRESHOLD
    }

    protected open fun getRandomNumber(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
        private const val FORWARD_THRESHOLD = 4
    }
}
