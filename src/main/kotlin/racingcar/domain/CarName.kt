package racingcar.domain

class CarName private constructor(private val value: String) {

    fun value(): String = value

    companion object {
        const val ERROR_EXCEED_LENGTH = "[ERROR] Car Name cannot exceed 5 characters."

        fun from(value: String): CarName {
            require(value.length <= 5) { ERROR_EXCEED_LENGTH }
            return CarName(value)
        }
    }
}
