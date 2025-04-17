package racingcar.domain

class Position(private var value: Int) {
    fun increase() {
        value++
    }

    fun toInt(): Int {
        return value
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Position

        return value == other.value
    }

    override fun hashCode(): Int {
        return value
    }
}
