package racingcar.domain

class CarName private constructor(private val value: String) {

    fun value(): String = value

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CarName) return false
        return value == other.value
    }

    override fun hashCode(): Int = value.hashCode()

    override fun toString(): String = value

    companion object {
        const val ERROR_EXCEED_LENGTH = "[ERROR] Car Name cannot exceed 5 characters."

        fun from(value: String): CarName {
            require(value.length <= 5) { ERROR_EXCEED_LENGTH }
            return CarName(value)
        }
    }
}
