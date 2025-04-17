package racingcar.domain.car

class Name(val name: String) {

    init {
        require(NAME_CONDITION.toRegex().matches(name)) { INVALID_NAME_ERROR }
        require(name.length in MIN_LENGTH..MAX_LENGTH) { NAME_LENGTH_OUT_OF_RANGE_ERROR }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Name) return false

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    companion object {
        private const val MIN_LENGTH: Int = 1
        private const val MAX_LENGTH: Int = 5
        private const val NAME_CONDITION: String = "^[a-zA-Z]+$"

        private const val NAME_LENGTH_OUT_OF_RANGE_ERROR: String =
            "Car name length must be between ${MIN_LENGTH} and ${MAX_LENGTH}."
        private const val INVALID_NAME_ERROR: String = "Car name must only contain alphabets."
    }
}
