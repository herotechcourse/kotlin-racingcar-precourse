package racingcar.domain

class CarName(val name: String) {
    init {
        if (name.isEmpty()) {
            throw IllegalArgumentException("Car names must not be empty.")
        }
        if (name.length > 5) {
            throw IllegalArgumentException("Car names must not exceed 5 characters.")
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CarName

        return name == other.name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}
