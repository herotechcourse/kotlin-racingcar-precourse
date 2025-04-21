package racingcar.domain.car

class Name(val value: String) {

    init {
        require(NAME_CONDITION.toRegex().matches(value)) { INVALID_NAME_ERROR }
        require(value.length in MIN_LENGTH..MAX_LENGTH) { NAME_LENGTH_OUT_OF_RANGE_ERROR }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Name) return false

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    companion object {
        private const val MIN_LENGTH: Int = 1
        private const val MAX_LENGTH: Int = 5
        private const val NAME_CONDITION: String = "^[a-zA-Z]+$"

        private const val NAME_LENGTH_OUT_OF_RANGE_ERROR: String =
            "[ERROR] Car name length must be between $MIN_LENGTH and $MAX_LENGTH."
        private const val INVALID_NAME_ERROR: String = "[ERROR] Car name must only contain alphabets and commas."
    }
}
