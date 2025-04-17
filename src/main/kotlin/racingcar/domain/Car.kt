package racingcar.domain

class Car(private val name: String) {
    private var distance: Int

    init {
        validateNameLength(name)
        validateContainingSpaces(name)
        this.distance = 0
    }

    private fun validateNameLength(name: String) {
        if (name.length > VALID_NAME_LENGTH) {
            throw IllegalArgumentException("car name must not exceed $VALID_NAME_LENGTH characters")
        }
    }

    private fun validateContainingSpaces(name: String) {
        if (name.contains(SPACE)) {
            throw IllegalArgumentException("car name must not contains spaces")
        }
    }

    companion object {
        private const val VALID_NAME_LENGTH: Int = 5
        private const val SPACE = " "
    }
}