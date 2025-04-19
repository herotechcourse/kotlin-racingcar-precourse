package racingcar.domain

class CarName(val value: String) {
    companion object {
        const val MAX_NAME_LENGTH = 5
    }

    init {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Car names must not be empty.")
        }
        if (value.length > MAX_NAME_LENGTH) {
            throw IllegalArgumentException("Car names must not exceed 5 characters.")
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CarName

        return value == other.value
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}
