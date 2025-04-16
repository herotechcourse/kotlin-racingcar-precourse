package racingcar.domain

class CarName private constructor(private val value: String) {

    fun value(): String = value

    companion object {
        fun from(value: String): CarName {
            require(value.length <= 5) {"[ERROR] Car Name cannot exceed 5 characters."}
            return CarName(value)
        }
    }
}